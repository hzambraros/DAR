resource "azurerm_virtual_network" "hr-vnet01" {
  name                = "hr-vnet01"
  resource_group_name = azurerm_resource_group.hr-tf.name
  location            = azurerm_resource_group.hr-tf.location
  address_space       = ["10.12.0.0/16"]
}

resource "azurerm_subnet" "hr-subnet01" {
  name                 = "hr-subnet01V01"
  resource_group_name  = azurerm_resource_group.hr-tf.name
  virtual_network_name = azurerm_virtual_network.hr-vnet01.name
  address_prefixes     = ["10.12.100.0/24"]

}

resource "azurerm_subnet" "hr-subnet02" {
  name                 = "hr-subnet02V01"
  resource_group_name  = azurerm_resource_group.hr-tf.name
  virtual_network_name = azurerm_virtual_network.hr-vnet01.name
  address_prefixes     = ["10.12.200.0/24"]

}


resource "azurerm_virtual_network" "hr-vnet02" {
  name                = "hr-vnet02"
  resource_group_name = azurerm_resource_group.hr-tf.name
  location            = azurerm_resource_group.hr-tf.location
  address_space       = ["10.13.0.0/16"]
}

resource "azurerm_subnet" "hr-subnet01" {
  name                 = "hr-subnet01V02"
  resource_group_name  = azurerm_resource_group.hr-tf.name
  virtual_network_name = azurerm_virtual_network.hr-vnet02.name
  address_prefixes     = ["10.13.100.0/24"]

}

resource "azurerm_subnet" "hr-subnet02" {
  name                 = "hr-subnet02V02"
  resource_group_name  = azurerm_resource_group.hr-tf.name
  virtual_network_name = azurerm_virtual_network.hr-vnet02.name
  address_prefixes     = ["10.13.200.0/24"]

}


resource "azurerm_virtual_network_peering" "1to2" {
    name                = "1to2"
    resource_group_name = azurerm_resource_group.hr-tf.name
    virtual_network_name      = azurerm_virtual_network.hr-vnet01.name
    remote_virtual_network_id = azurerm_virtual_network.hr-vnet02.id
}
resource "azurerm_virtual_network_peering" "2to1" {
    name                = "2to1"
    resource_group_name = azurerm_resource_group.hr-tf.name
    virtual_network_name      = azurerm_virtual_network.hr-vnet02.name
    remote_virtual_network_id = azurerm_virtual_network.hr-vnet01.id
}