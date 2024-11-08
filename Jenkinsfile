pipeline {
    agent any

    environment {
        AZURE_CLIENT_ID = credentials(' AZURE_CLIENT_ID')
        AZURE_CLIENT_SECRET = credentials('AZURE_CLIENT_SECRET')
        AZURE_TENANT_ID = credentials('AZURE_TENANT_ID')
    }

    stages {
        stage('Prepare Groovy Script') {
            steps {
                script {
                    // You can load the Groovy script from a file or define it inline
                    def groovyScript = readFile 'createResourceGroup.groovy'
                    writeFile file: 'createResourceGroup.groovy', text: groovyScript
                }
            }
        }

        stage('Execute Groovy Script') {
            steps {
                // Execute the Groovy script to create the resource group
                sh '''
                chmod +x createResourceGroup.groovy
                ./createResourceGroup.groovy
                '''
            }
        }
    }

    post {
        always {
            // Clean up, if needed
            echo 'Cleaning up resources...'
        }
    }
}
 
