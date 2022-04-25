//vnet01------subnet01
resource "azurerm_network_security_group" "nsg_hr_vnet01_hrsubnet01" {
  name                = "nsg-hrsubnet01"
  location            = azurerm_resource_group.hr-tf.location
  resource_group_name = azurerm_resource_group.hr-tf.name
}

resource "azurerm_network_security_rule" "nsg_hr_vnet01_hrsubnet01"{
    name                       = "SSH_Entrante"
    priority                   = 100
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "*"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
    resource_group_name        = azurerm_resource_group.hr-tf.name
    network_security_group_name= azurerm_network_security_group.nsg_hr_vnet01_hrsubnet01.name
}

resource "azurerm_subnet_network_security_group_association" "nsg_hr_vnet01_hrsubnet01" {
  subnet_id                 = azurerm_subnet.hr-subnet01.id
  network_security_group_id = azurerm_network_security_group.nsg_hr_vnet01_hrsubnet01.id
}

//subnet02
resource "azurerm_network_security_group" "nsg_hr_vnet01_hrsubnet02" {
  name                = "nsg-hrsubnet02"
  location            = azurerm_resource_group.hr-tf.location
  resource_group_name = azurerm_resource_group.hr-tf.name
}

resource "azurerm_network_security_rule" "nsg_hr_vnet01_hrsubnet02"{
    name                       = "SSH_Entrante"
    priority                   = 100
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "*"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
    resource_group_name        = azurerm_resource_group.hr-tf.name
    network_security_group_name= azurerm_network_security_group.nsg_hr_vnet01_hrsubnet02.name
}

resource "azurerm_subnet_network_security_group_association" "nsg_hr_vnet01_hrsubnet02" {
  subnet_id                 = azurerm_subnet.hr-subnet02.id
  network_security_group_id = azurerm_network_security_group.nsg_hr_vnet01_hrsubnet02.id
}


//vnet02------subnet01
resource "azurerm_network_security_group" "nsg_hr_vnet02_hrsubnet01" {
  name                = "nsg-hrVnet02subnet01"
  location            = azurerm_resource_group.hr-tf.location
  resource_group_name = azurerm_resource_group.hr-tf.name
}

resource "azurerm_network_security_rule" "nsg_hr_vnet02_hrsubnet01"{
    name                       = "SSH_Entrante"
    priority                   = 100
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "*"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
    resource_group_name        = azurerm_resource_group.hr-tf.name
    network_security_group_name= azurerm_network_security_group.nsg_hr_vnet02_hrsubnet01.name
}

resource "azurerm_subnet_network_security_group_association" "nsg_hr_vnet02_hrsubnet01" {
  subnet_id                 = azurerm_subnet.hr-subnet02.id
  network_security_group_id = azurerm_network_security_group.nsg_hr_vnet02_hrsubnet01.id
}

//subnet02
resource "azurerm_network_security_group" "nsg_hr_vnet02_hrsubnet02" {
  name                = "nsg-hrVnet02subnet02"
  location            = azurerm_resource_group.hr-tf.location
  resource_group_name = azurerm_resource_group.hr-tf.name
}

resource "azurerm_network_security_rule" "nsg_hr_vnet02_hrsubnet02"{
    name                       = "SSH_Entrante"
    priority                   = 100
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "*"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
    resource_group_name        = azurerm_resource_group.hr-tf.name
    network_security_group_name= azurerm_network_security_group.nsg_hr_vnet02_hrsubnet02.name
}

resource "azurerm_subnet_network_security_group_association" "nsg_hr_vnet02_hrsubnet02" {
  subnet_id                 = azurerm_subnet.hr-subnet02.id
  network_security_group_id = azurerm_network_security_group.nsg_hr_vnet02_hrsubnet02.id
}