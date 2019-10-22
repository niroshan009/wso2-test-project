pipeline {
    agent any 
    stages {
        stage('Build') { 
            script {
                 server.esb.url = "https://localhost:9444"
            }
            steps {
                sh 'echo ${server.esb.url}'
		sh 'curl -u admin:password http://localhost:8081/artifactory/generic-local/wso2carbon.jks -o wso2carbon.jks'
                sh './gradlew buildAndDeploy -Penvironment=local --stacktrace'
            }
        }
        stage('Test') { 
            steps {
                sh './gradlew cucumber'
            }
        }
        stage('Deploy') {

            steps {
                withCredentials([steps.usernamePassword(
      credentialsId: 'ARTIFACTORY',
      usernameVariable: 'JFROG_USERNAME_1',
      passwordVariable: 'JFROG_PASSWORD_1')]) {

                    echo '${JFROG_USERNAME_1}'
                    echo '${JFROG_PASSWORD_1}'
                    sh './gradlew uploadToArtifactory'
                }
                 

            }
        }
    }
}
