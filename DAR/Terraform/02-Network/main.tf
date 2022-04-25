# We strongly recommend using the required_providers block to set the
# Azure Provider source and version being used
terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.0.0"
    }
  }
}

# Configure the Microsoft Azure Provider
provider "azurerm" {
  features {}
  subscription_id = "dd7a597a-f85c-44dd-8ec8-d64944fc8699"
  tenant_id = "b4f2963a-51fb-481d-89e2-173cd5920704"
}

# Create a resource group
resource "azurerm_resource_group" "hr-tf" {
  name     = "hr-tf"
  location = "West Europe"
}