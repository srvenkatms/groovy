pipeline {
    agent any

    environment {
        AZURE_CLIENT_ID = credentials('AZURE_CLIENT_ID')
        AZURE_CLIENT_SECRET = credentials('AZURE_CLIENT_SECRET')
        AZURE_TENANT_ID = credentials('AZURE_TENANT_ID')
    }

    stages {
        stage('Load and Execute Groovy Script') {
            steps {
                script {
                    // Load the Groovy script
                    def createResourceGroupScript = load 'createResourceGroup.groovy'
                    
                    // Call the function defined in createResourceGroup.groovy
                    createResourceGroupScript.createAzureResourceGroup('myResourceGroup', 'EastUS')
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up resources...'
        }
    }
}
