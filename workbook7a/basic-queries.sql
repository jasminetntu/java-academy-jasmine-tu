/*
workbook 7a
basic-queries exercise
*/

-- 1. What is the name of the table that holds the items Northwind sells?
-- ANSWER: Products

-- 2. Write a query to list the product id, product name, and unit price of every product.
SELECT productID, productName, unitPrice 
FROM northwind.products;

-- 3. Do same as (2), except this time, order in ascending order by price.
SELECT productID, productName, unitPrice 
FROM northwind.products
ORDER BY unitPrice ASC;

-- 4. What are the products that we carry where the unit price is $7.50 or less?
SELECT * FROM northwind.products
WHERE unitPrice <= 7.50;

-- 5. What are the products that we carry where we have at least 100 units on hand? 
--    Order them in descending order by price.
SELECT * FROM northwind.products
WHERE unitsInStock >= 100
ORDER BY unitPrice DESC;

-- 6. Do same as (5). But if two or more have the same price, list those in ascending order by product name.
SELECT * FROM northwind.products
WHERE unitsInStock >= 100
ORDER BY unitPrice DESC, productName ASC;

-- 7. What are the products that we carry where we have no units on hand, but 1 or more units of them on backorder? 
--    Order them by product name.
SELECT * FROM northwind.products
WHERE unitsInStock = 0 AND unitsOnOrder > 0
ORDER BY productName ASC;

-- 8. What is the name of the table that holds the types (categories) of the items Northwind sells?
-- ANSWER: Categories

-- 9. Write a query that lists all of the columns and all the rows of the categories table? 
--    What is the category id of seafood?
SELECT * FROM northwind.categories; -- category id of seafood = 8

-- 10. How does the Products table identify the type (category) of each item sold? 
--     Write a query to list all of the seafood items we carry.
-- ANSWER: By referencing the category id
SELECT * FROM northwind.products
	INNER JOIN northwind.categories
    ON northwind.products.categoryID = northwind.categories.categoryID
WHERE northwind.categories.categoryName = 'Seafood';

-- 11. What are the first and last names of all of the Northwind employees?
SELECT firstName, lastName FROM northwind.employees;

-- 12. What employees have "manager" in their titles?
SELECT * FROM northwind.employees
WHERE title LIKE '%manager%';

-- 13. List the distinct job titles in employees.
SELECT DISTINCT title FROM northwind.employees;

-- 14. What employees have a salary that is between $2000 and $2500?
SELECT * FROM northwind.employees
WHERE salary BETWEEN 2000 AND 2500;

-- 15. List all the information about all of Northwind's suppliers.
SELECT * FROM northwind.suppliers;

-- 16. Examine the Products table. How do you know what supplier supplies each product? 
--     Write a query to list all the items that "Tokyo Traders" supplies to Northwind.
-- ANSWER: By referencing supplier ID
SELECT * FROM northwind.products
	INNER JOIN northwind.suppliers
    ON northwind.products.supplierID = northwind.suppliers.supplierID
WHERE northwind.suppliers.companyName = 'Tokyo Traders';

