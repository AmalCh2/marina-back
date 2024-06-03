package com.arabsoft.marinaBack.service;
import com.arabsoft.marinaBack.dto.Client;
import com.arabsoft.marinaBack.dto.Utilisateur;
import com.arabsoft.marinaBack.repository.UtilisateurRepository;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.arabsoft.marinaBack.config.encoding.encode;
import static com.arabsoft.marinaBack.config.encoding.generateRandomPassword;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private JavaMailSender mailSender;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id_utilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(id_utilisateur).orElse(null);
        System.out.println("getUtilisateurById result : " + utilisateur);
        return utilisateur;
    }


    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMot_de_passe(encode(utilisateur.getMot_de_passe()));

        Utilisateur utilisateurCreated = utilisateurRepository.save(utilisateur);
        return utilisateurCreated;
    }

    public void deleteUtilisateurByEmail(Long id_utilisateur) {
        utilisateurRepository.deleteById(id_utilisateur);
    }

    public Utilisateur updateUtilisateur(Long id_utilisateur, Utilisateur utilisateur) {
        Utilisateur oldUtilisateurFound;
        Optional<Utilisateur> oldUtilisateur = utilisateurRepository.findById(id_utilisateur);
        if (oldUtilisateur.isPresent()) {
            oldUtilisateurFound = oldUtilisateur.get();
        } else {
            throw new RuntimeException("id_utilisateur not present in database -> No update to be done !!");
        }
        if (utilisateur.getId_utilisateur() != null) {
            oldUtilisateurFound.setId_utilisateur(utilisateur.getId_utilisateur());
        }
        if (utilisateur.getNom_utilisateur() != null) {
            oldUtilisateurFound.setNom_utilisateur(utilisateur.getNom_utilisateur());
        }
        if (utilisateur.getMot_de_passe() != null) {
            oldUtilisateurFound.setMot_de_passe(utilisateur.getMot_de_passe());
        }

        /// if(utilisateur.getId_port() != null ) { oldUtilisateurFound.setId_port(utilisateur.getId_port());}
        return utilisateurRepository.save(oldUtilisateurFound);
    }


    public int verifyuserPassword(Long id, String password) {
        String pwddb = utilisateurRepository.getuserPasswordById(id);
        String pwd = encode(password);
        if (pwddb.equals(pwd)) {
            return 1;
        }
        return 0;
    }


    public void sendResetPasswordEmail(String recipientEmail, String newPassword) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setSubject("Reset Password for Your Account");
            message.setFrom("your_email@example.com"); // Replace with your sender email
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientEmail));

            // Email body content with the new password
            String body = "Your password has been reset. Your new password is: " + newPassword;
            message.setContent(body, "text/plain");

            mailSender.send(message);
            System.out.println("Reset password email sent to: " + recipientEmail);
        } catch (Exception e) {
            System.err.println("Error sending reset password email: " + e.getMessage());
        }
    }


    public void resetPassword(String username) {
        String newPassword=generateRandomPassword();
        String mail="yosrbenamor2002@gmail.com";
Long id = utilisateurRepository.getUseridByUsername(username);
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur Utilisateur = optionalUtilisateur.get();
            Utilisateur.setMot_de_passe(encode(newPassword));
            utilisateurRepository.save(Utilisateur);
        } else {
            throw new RuntimeException("Client not found");
        }
        // Send reset password email if successful
        sendResetPasswordEmail(mail, newPassword);
    }


}