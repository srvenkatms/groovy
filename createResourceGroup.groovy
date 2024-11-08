// createResourceGroup.groovy
def createAzureResourceGroup(resourceGroupName, location) {
    sh """
    az login --service-principal -u "$AZURE_CLIENT_ID" -p "$AZURE_CLIENT_SECRET" --tenant "$AZURE_TENANT_ID"
    az group create --name ${resourceGroupName} --location ${location}
    az group show --name ${resourceGroupName}
    """
}

return this
