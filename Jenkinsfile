pipeline { 
    environment { 
        registryCredential = 'docker-jenkins' 
        dockerImageBE = ''
        dockerImageFE = ''
    }

    agent any 
    
    stages{
        
        stage('Cloning our Git') { 

            steps { 
                
                git credentialsId: 'github-credential', url:'https://github.com/nihar01/SportItUp-Application'
                
            }

        }
        stage('Maven Build'){
            steps{
                sh 'mvn clean install'
            }
        }
        
       stage('Remove Previous Docker Images If Exists') {
            steps {
                sh 'docker rmi springboot-docker-container  react-docker-container 2> /dev/null || true'
            }
        }
        
        stage('containarize'){
            steps{
                sh 'docker-compose build'
            }
        }
        stage('Rename Docker Image name to push on Docker Hub') {
            steps {
                sh 'docker tag springboot-docker-container nihar01/sportitup'
                sh 'docker tag  react-docker-container nihar01/sportitup-frontend'
                
            }
        }
        stage('Deploy on Docker Hub') {
            steps {
                script {
                    docker.withRegistry( '', 'docker-jenkins' ) {
                      sh 'docker push nihar01/sportitup-frontend'
                      sh 'docker push nihar01/sportitup'
                    }
                }
            }
        }
        stage('Deploy with ansible') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: './ansible_deployment/ansible_inventory', playbook: './ansible_deployment/ansible_deploy.yml', sudoUser: null
            }
        }
        
        
    }
    
}
