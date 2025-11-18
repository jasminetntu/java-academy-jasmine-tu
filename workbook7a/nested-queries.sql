/*
jasmine tu
yuu ltca - workbook 7a
nested-queries exercise
*/

-- 1. What is the product name(s) of the most expensive products? 
SELECT productName FROM northwind.products
WHERE unitPrice = (
	SELECT MAX(unitPrice) FROM northwind.products
    );

-- 2. What is the order id, shipping name and shipping address of all orders shipped via "Federal Shipping"? 
SELECT orderId, shipName, shipAddress 
FROM northwind.orders
WHERE shipVia = (
	SELECT shipperID FROM northwind.shippers
    WHERE companyName = 'Federal Shipping'
);

-- 3. What are the order ids of the orders that ordered "Sasquatch Ale"? 
-- HINT: Find the product id of "Sasquatch Ale" in a subquery and then use that value to find the matching orders from the `order details` table. 
-- Because the `order details` table has a space in its name, you will need to surround it with back ticks in the FROM clause.
SELECT orderID FROM northwind.`order details`
WHERE productID = (
	SELECT productID FROM northwind.products
    WHERE productName = 'Sasquatch Ale'
);

-- 4. What is the name of the employee that sold order 10266?
SELECT firstName, lastName 
FROM northwind.employees
WHERE employeeID = (
	SELECT employeeID FROM northwind.orders
    WHERE orderID = 10266
);

-- 5. What is the name of the customer that bought order 10266?
SELECT companyName, contactName 
FROM northwind.customers
WHERE customerID = (
	SELECT customerID FROM northwind.orders
    WHERE orderID = 10266
);
