pipeline {
    agent any

    environment {
        AZURE_CLIENT_ID = credentials('AZURE_CLIENT_ID')
        AZURE_CLIENT_SECRET = credentials('AZURE_CLIENT_SECRET')
        AZURE_TENANT_ID = credentials('AZURE_TENANT_ID')
    }

    stages {
        stage('Install Azure CLI') {
            steps {
                script {
                    // Check if Azure CLI is installed; if not, install it
                    def cliInstalled = sh(script: 'command -v az', returnStatus: true) == 0
                    if (!cliInstalled) {
                        echo 'Installing Azure CLI...'
                        sh '''
                        curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash
                        '''
                    } else {
                        echo 'Azure CLI is already installed.'
                    }
                }
            }
        }

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
