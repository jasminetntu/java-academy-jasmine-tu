/*
jasmine tu
yuu ltca - workbook 7a
joins exercise
*/

-- 1. List the product id, product name, unit price and category name of all products. 
--    Order by category name and within that, by product name.
SELECT productId, productName, unitPrice, categoryName
FROM northwind.products
INNER JOIN northwind.categories
	ON northwind.products.categoryId = northwind.categories.categoryId
ORDER BY categoryName, productName;


-- 2. List the product id, product name, unit price and supplier name of all products that cost more than $75. 
--    Order by product name.
SELECT productId, productName, unitPrice, companyName
FROM northwind.products
INNER JOIN northwind.suppliers
	ON northwind.products.supplierId = northwind.suppliers.supplierId
WHERE unitPrice > 75
ORDER BY productName;


-- 3. List the product id, product name, unit price, category name, and supplier name of every product. 
--    Order by product name.
SELECT productId, productName, unitPrice, categoryName, companyName
FROM northwind.products
	INNER JOIN northwind.categories
		ON northwind.products.categoryId = northwind.categories.categoryId
	INNER JOIN northwind.suppliers
		ON northwind.products.supplierId = northwind.suppliers.supplierId
ORDER BY productName;


-- 4. What is the product name(s) and categories of the most expensive products? 
SELECT productName, categoryName
FROM northwind.products
	INNER JOIN northwind.categories
		ON northwind.products.categoryId = northwind.categories.categoryId
WHERE unitPrice = (
	SELECT MAX(unitPrice) FROM northwind.products
);


-- 5. List the order id, ship name, ship address, and shipping company name of every order that shipped to Germany.
SELECT orderId, shipName, shipAddress, companyName
FROM northwind.orders
	INNER JOIN northwind.shippers
    ON northwind.orders.shipVia = northwind.shippers.shipperId
WHERE shipCountry = 'Germany';


-- 6. List the order id, order date, ship name, ship address of all orders that ordered "Sasquatch Ale"?
SELECT northwind.orders.orderId, orderDate, shipName, shipAddress
FROM northwind.orders
	INNER JOIN northwind.`order details`
    ON northwind.orders.orderId = northwind.`order details`.orderId
WHERE productId = (
	SELECT productId FROM northwind.products
    WHERE productName = 'Sasquatch Ale'
);
