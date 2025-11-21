/*
jasmine tu
yuu ltca - workbook 7a
insert-update-delete exercise
*/

-- 1. Add a new supplier.
INSERT INTO northwind.suppliers 
	(supplierId, companyName, contactName, contactTitle, address, city, postalCode, country, phone) -- omitted region, fax, homepage
VALUES (30, 'USPS', 'Ava Kemmerer', 'Sales Manager', '1234 My Street', 'San Jose', 95148, 'USA', '(000) 000-0000');

SELECT * FROM northwind.suppliers
WHERE supplierId = 30;

-- 2. Add a new product provided by that supplier
INSERT INTO northwind.products
	(productId, productName, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued)
VALUES (78, 'Sour Blue Raspberry Gushers', 30, 3, '1 lb jars', 20, 111, 12, 10, 0);

SELECT * FROM northwind.products
WHERE supplierId = 30;

-- 3. List all products and their suppliers.
SELECT * FROM northwind.products
INNER JOIN northwind.suppliers
	ON northwind.products.supplierId = northwind.suppliers.supplierId;

-- 4. Raise the price of your new product by 15%.
UPDATE northwind.products
SET unitPrice = (unitPrice * 1.15)
WHERE productId = 78;

-- 5. List the products and prices of all products from that supplier.
SELECT * FROM northwind.products
INNER JOIN northwind.suppliers
	ON northwind.products.supplierId = northwind.suppliers.supplierId
WHERE northwind.products.supplierId = 30;

-- 6. Delete the new product.
DELETE FROM northwind.products
WHERE productId = 78;

-- 7. Delete the new supplier.
DELETE FROM northwind.suppliers
WHERE supplierId = 30;

-- 8. List all products.
SELECT * FROM northwind.products;

-- 9. List all suppliers.
SELECT * FROM northwind.suppliers;
