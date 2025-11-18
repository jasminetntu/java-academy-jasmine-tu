/*
jasmine tu
yuu ltca - workbook 7a
aggregates-and-grouping exercise
*/

-- 1. How many suppliers are there?
SELECT * FROM northwind.suppliers;
-- ANSWER: 29

-- 2. What is the sum of all the employee's salaries?
SELECT SUM(salary) AS totalSalaries
FROM northwind.employees;

-- 3. What is the price of the cheapest item that Northwind sells?
SELECT MIN(unitPrice) AS cheapestPrice
FROM northwind.products;

-- 4. What is the average price of items that Northwind sells?
SELECT AVG(unitPrice) AS averagePrice
FROM northwind.products;

-- 5. What is the price of the most expensive item that Northwind sells?
SELECT MAX(unitPrice) AS mostExpensivePrice
FROM northwind.products;

-- * FOR 6-8, only look at Products table.

-- 6. What is the supplier ID of each supplier and the number of items they supply?
SELECT supplierID, COUNT(productID) AS numItemsSupplied
FROM northwind.products
GROUP BY supplierID;

-- 7. What is the category ID of each category and the average price of each item in the category?
SELECT categoryID, AVG(unitPrice) AS averagePrice
FROM northwind.products
GROUP BY categoryID;

-- 8. For suppliers that provide at least 5 items to Northwind, what is the supplier ID of each supplier and the number of items they supply?
SELECT supplierID, COUNT(productID) AS numItemsSupplied
FROM northwind.products
GROUP BY supplierID
HAVING COUNT(productID) >= 5;

-- 9. List the product id, product name, and inventory value (calculated by multiplying unit price by the number of units on hand). 
--    Sort the results in descending order by value. If two or more have the same value, order by product name.
SELECT productID, productName, (unitPrice * unitsInStock) AS inventoryValue
FROM northwind.products
ORDER BY InventoryValue DESC, productName;
