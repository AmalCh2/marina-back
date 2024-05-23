pipeline{
    agent any



    stages {


        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/main']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/AmalCh2/marina-back.git']]])
            }
        }


stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t amalchnitir/marina_back:latest .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {
				sh 'docker login -u aamalchnitir --password dckr_pat_gsUPMF96MBMpP0lzoHchzpeStXI'
                                            }
		  }
	    
	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push amalchnitir/marina_back:latest'
                                            }
		  }
     
}
	    
        post {
       always {
            cleanWs()
       }
    }

    
	
}
       
