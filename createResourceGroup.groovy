node {
    def resourceGroupName = "myResourceGroup"
    def location = "EastUS" // Update the region as per your requirement

    stage('Login to Azure') {
        // Login to Azure using a service principal
        sh '''
        az login --service-principal -u "$AZURE_CLIENT_ID" -p "$AZURE_CLIENT_SECRET" --tenant "$AZURE_TENANT_ID"
        '''
    }

    stage('Create Resource Group') {
        // Create the resource group using Azure CLI
        sh """
        az group create --name $resourceGroupName --location $location
        """
    }

    stage('Verify Resource Group Creation') {
        // Verify if the resource group was created successfully
        sh """
        az group show --name $resourceGroupName
        """
    }
}
