pipeline {
    agent any

    environment {
        AZURE_CLIENT_ID = credentials('azure-client-id')
        AZURE_CLIENT_SECRET = credentials('azure-client-secret')
        AZURE_TENANT_ID = credentials('azure-tenant-id')
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
 
