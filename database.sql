CREATE TABLE Warehouse (
    WarehouseID INT AUTO_INCREMENT PRIMARY KEY,
    WarehouseName VARCHAR(50) NOT NULL,
    Location VARCHAR(100)
) ENGINE=InnoDB;

CREATE TABLE Outlet (
    OutletID INT AUTO_INCREMENT PRIMARY KEY,
    BranchName VARCHAR(50) NOT NULL,
    Location VARCHAR(100)
) ENGINE=InnoDB;

CREATE TABLE Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Description TEXT,
    Category VARCHAR(50),
    Price DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE WarehouseInventory (
    WarehouseID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    PRIMARY KEY (WarehouseID, ProductID),
    FOREIGN KEY (WarehouseID) REFERENCES Warehouse(WarehouseID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE OutletInventory (
    OutletID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    PRIMARY KEY (OutletID, ProductID),
    FOREIGN KEY (OutletID) REFERENCES Outlet(OutletID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE StockDelivery (
    DeliveryID INT AUTO_INCREMENT PRIMARY KEY,
    WarehouseID INT NOT NULL,
    OutletID INT NOT NULL,
    DeliveryDate DATE NOT NULL,
    FOREIGN KEY (WarehouseID) REFERENCES Warehouse(WarehouseID) ON DELETE CASCADE,
    FOREIGN KEY (OutletID) REFERENCES Outlet(OutletID) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE DeliveryDetails (
    DeliveryID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    PRIMARY KEY (DeliveryID, ProductID),
    FOREIGN KEY (DeliveryID) REFERENCES StockDelivery(DeliveryID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Customer (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(100) NOT NULL,
    Contact VARCHAR(50),
    Email VARCHAR(100)
) ENGINE=InnoDB;

CREATE TABLE TransactionTable (
    TransactionID INT AUTO_INCREMENT PRIMARY KEY,
    OutletID INT NOT NULL,
    CustomerID INT,
    TransactionDate DATETIME NOT NULL,
    TotalAmount DECIMAL(10,2),
    FOREIGN KEY (OutletID) REFERENCES Outlet(OutletID) ON DELETE CASCADE,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE TransactionDetails (
    TransactionID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (TransactionID, ProductID),
    FOREIGN KEY (TransactionID) REFERENCES TransactionTable(TransactionID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
) ENGINE=InnoDB;

DELIMITER $$
CREATE TRIGGER trg_after_transaction_details_insert
AFTER INSERT ON TransactionDetails
FOR EACH ROW
BEGIN
    DECLARE v_OutletID INT;
    SELECT OutletID INTO v_OutletID 
    FROM TransactionTable 
    WHERE TransactionID = NEW.TransactionID;
    
    UPDATE OutletInventory
    SET Quantity = Quantity - NEW.Quantity
    WHERE OutletID = v_OutletID
      AND ProductID = NEW.ProductID;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_after_delivery_details_insert
AFTER INSERT ON DeliveryDetails
FOR EACH ROW
BEGIN
    DECLARE v_OutletID INT;
    DECLARE v_WarehouseID INT;
    
    SELECT OutletID, WarehouseID INTO v_OutletID, v_WarehouseID
    FROM StockDelivery
    WHERE DeliveryID = NEW.DeliveryID;
    
    UPDATE OutletInventory
    SET Quantity = Quantity + NEW.Quantity
    WHERE OutletID = v_OutletID AND ProductID = NEW.ProductID;
    
    UPDATE WarehouseInventory
    SET Quantity = Quantity - NEW.Quantity
    WHERE WarehouseID = v_WarehouseID AND ProductID = NEW.ProductID;
END$$
DELIMITER ;