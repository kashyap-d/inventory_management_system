INSERT INTO Warehouse (WarehouseName, Location) VALUES
('Central Warehouse', '123 Warehouse St, City Center');

INSERT INTO Outlet (BranchName, Location) VALUES
('Downtown Branch', '456 Market St, Downtown'),
('Uptown Branch', '789 High St, Uptown'),
('Suburban Branch', '101 Greenway Ave, Suburb');

INSERT INTO Product (ProductName, Description, Category, Price) VALUES
('Laptop', 'High-performance laptop', 'Electronics', 999.99),
('Smartphone', 'Latest model smartphone', 'Electronics', 699.99),
('Headphones', 'Noise-canceling over-ear headphones', 'Accessories', 199.99),
('Keyboard', 'Mechanical keyboard with RGB lighting', 'Accessories', 79.99);

INSERT INTO WarehouseInventory (WarehouseID, ProductID, Quantity) VALUES
(1, 1, 100),
(1, 2, 200),
(1, 3, 150),
(1, 4, 180);

INSERT INTO OutletInventory (OutletID, ProductID, Quantity) VALUES
(1, 1, 15),
(1, 2, 30),
(1, 3, 20),
(1, 4, 25),
(2, 1, 10),
(2, 2, 25),
(2, 3, 15),
(2, 4, 20),
(3, 1, 12),
(3, 2, 28),
(3, 3, 18),
(3, 4, 22);

INSERT INTO StockDelivery (WarehouseID, OutletID, DeliveryDate) VALUES
(1, 1, '2025-03-28'),
(1, 2, '2025-03-28'),
(1, 3, '2025-03-28');

INSERT INTO DeliveryDetails (DeliveryID, ProductID, Quantity) VALUES
(1, 1, 10),
(1, 2, 15),
(2, 3, 12),
(2, 4, 18),
(3, 1, 14),
(3, 3, 10);

INSERT INTO Customer (CustomerName, Contact, Email) VALUES
('John Doe', '1234567890', 'johndoe@example.com'),
('Jane Smith', '0987654321', 'janesmith@example.com'),
('Alice Johnson', '1122334455', 'alicej@example.com');

INSERT INTO TransactionTable (OutletID, CustomerID, TransactionDate, TotalAmount) VALUES
(1, 1, '2025-03-28 10:30:00', 1799.98),
(2, 2, '2025-03-28 11:45:00', 699.99),
(3, 3, '2025-03-28 14:15:00', 278.98);

INSERT INTO TransactionDetails (TransactionID, ProductID, Quantity, UnitPrice) VALUES
(1, 1, 1, 999.99),
(1, 2, 1, 699.99),
(2, 2, 1, 699.99),
(3, 3, 2, 139.49);
