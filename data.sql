INSERT IGNORE INTO Customer (CustomerID, FirstName, LastName, Address1, Address2, City, State, Zip, Country) VALUES
(1, 'Phillip', 'Anthropy', 'T-3322 Fairlight Dr', '', 'SASKATOON', 'SK', 'S7M 3Y4', 'CANADA'), 
(2, 'Valentino', 'Morose', '215 Toronto Ave', '', 'OSHAWA', 'ON', 'L1H 3C2', 'CANADA'), 
(3, 'Jackson', 'Pot', '511-200 Dora Spencer Rd', '', 'YORK', 'ON', 'M6M 5G5', 'CANADA');

INSERT IGNORE INTO SalesRep (SalesRepID, FirstName, LastName, Address1, Address2, City, State, Zip, Country) VALUES
(1, 'Ruby Von', 'Rails', '226 Hwy 63', '', 'THORNE', 'ON', 'P0H 2J0', 'CANADA'), 
(2, 'Brandon', 'Guidelines', '4-982 Boul Saint-Rene O', '', 'GATINEAU', 'QC', 'J8T 7P9', 'CANADA');

INSERT IGNORE INTO Time (TimeID, `Year`, `Quarter`, `Month`, `Week`) VALUES
(1, '2016', '2', '5', '2'),
(2, '2017', '3', '7', '3'),
(3, '2017', '3', '8', '4'),
(4, '2018', '1', '2', '2');

INSERT IGNORE INTO Product (ProductID, ProductName, ProductDescription, UnitPrice, UnitCost) VALUES
(1, 'TP03A Digital Food Cooking Thermometer', 'Sold by i-Tronics', 13.14, 10.88), 
(2, 'TROND AC2 USB Audio Adapter', 'Sold by TROND Official', 11.89, 11.04),
(3, 'Bily BG370200 Retractable Safety Gate', 'Fulfilled by Amazon', 55.99, 44.99),
(4, 'Bluedio Vinyl Plus Bluetooth Headphones', 'Sold by Bluedio', 112.99, 86.99),
(5, 'AUKEY USB Type C Cable 3-Pack', 'Sold by Aukey Direct', 17.99, 3.25);

INSERT IGNORE INTO Sales (CustomerID, ProductID, SalesRepID, TimeID, SalesAmount) VALUES 
(1, 1, 2, 1, 13.14),
(2, 3, 2, 2, 55.99),
(2, 4, 1, 2, 112.99),
(3, 2, 1, 3, 11.89),
(3, 5, 1, 4, 17.99);
