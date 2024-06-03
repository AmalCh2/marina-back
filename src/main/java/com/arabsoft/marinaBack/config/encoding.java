package com.arabsoft.marinaBack.config;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class encoding {

    private static final int SECRET_NUMBER = 297; // Replace with a more complex key

    public static String encode(String password) {
        StringBuilder encodedPassword = new StringBuilder();
        encodedPassword.append('z'); // Prepend with 'z'

        for (char c : password.toCharArray()) {
            int asciiValue = (int) c;
            int encodedValue = (asciiValue + SECRET_NUMBER) % 128; // Modulo 128 to keep within ASCII range
            encodedPassword.append((char) encodedValue);
        }

        encodedPassword.append('a'); // Append with 'a'
        return encodedPassword.toString();
    }

    public static String generateRandomPassword() {
        int length=8;
        // Use a strong random number generator (ThreadLocalRandom is recommended)
        StringBuilder sb = new StringBuilder();
        Random random = ThreadLocalRandom.current();
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = upperCaseChars.toLowerCase();
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-+";
        String allChars = upperCaseChars + lowerCaseChars + numberChars + specialChars;

        // Ensure at least one character from each category
        sb.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length())));
        sb.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length())));
        sb.append(numberChars.charAt(random.nextInt(numberChars.length())));
        sb.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Generate remaining characters with any combination
        for (int i = 4; i < length; i++) {
            sb.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the characters for better randomness
        char[] passwordChars = sb.toString().toCharArray();
        for (int i = 0; i < passwordChars.length; i++) {
            int j = random.nextInt(passwordChars.length);
            char temp = passwordChars[i];
            passwordChars[i] = passwordChars[j];
            passwordChars[j] = temp;
        }

        return new String(passwordChars);
    }


}
