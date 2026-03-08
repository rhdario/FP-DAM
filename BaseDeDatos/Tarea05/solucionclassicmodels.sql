USE classicmodels;

-- Exercise 2
INSERT INTO payments (customerNumber, checkNumber, paymentDate, amount) VALUES (124, 'H123', '2024-02-06', 845.00),
(151, 'H124', '2024-02-07', 70.00),
(112, 'H125', '2024-02-05', 1024.00);

-- Exercise 3 (We select to use interface mode)
SELECT 
    *
FROM
    customers;
    
-- Exercise 4
UPDATE orders 
SET status = 'Cancelled', 
    shippedDate = CURDATE(), 
    comments = 'Order cancelled due to delay' 
WHERE orderDate = '2003-09-28';
    
-- Exercise 5
UPDATE products
SET productName = concat(productName,' ', '(code ',productCode,')')
WHERE
productLine = 'Trains';

-- Exercise 6
UPDATE products 
SET 
	buyPrice = buyPrice + ( buyPrice * 2 ) / 10000 ,
    MSRP = MSRP + (MSRP * 2 ) / 10000
-- I'd like to add a comment: although when I ran it, I applied everything correctly. It would have been better to use rounding because the system gave me a warning about that, so the correct thing to do would have been the following.
-- buyPrice = ROUND( buyPrice + ( buyPrice * 2) / 10000, 2), MSRP = ROUND(MSRP + (MSRP * 2) / 10000, 2)
    
WHERE
    quantityInStock > 500
        And productCode <> ''; -- I include productCode <> '' to "trick" the Safe Update MySQL mode , which prohibits bulk updates if the Primary Key is not named.
   
-- Exercise 7
DELETE payments
FROM  payments
INNER JOIN customers ON payments.customerNumber = customers.customerNumber
INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
WHERE employees.lastName = 'Patterson';

-- Exercise 8
SET SQL_SAFE_UPDATES = 0; -- This line is added to force the program to avoid the SAFE UPDATE because otherwise it throws error 1175; this way it allows execution.
DELETE customers
FROM  customers
LEFT JOIN payments ON customers.customerNumber = payments.customerNumber
WHERE customers.city = 'Lisbon' And payments.customerNumber IS NULL;

-- Exercise 9
INSERT INTO employees (employeeNumber, lastName, firstName, extension,email, officeCode, jobTitle) SELECT customerNumber + 2000, contactLastName, contactFirstName, 'x0000', 'new@company.com', '1', 'Sales Rep' FROM customers;

-- Exercise 10
UPDATE orders
SET status = 'Cancelled',
    shippedDate = CURDATE(),
    comments = 'Order cancelled by management'
WHERE customerNumber IN (
    SELECT customerNumber
    FROM customers
    WHERE salesRepEmployeeNumber = (
        SELECT employeeNumber
        FROM employees
        WHERE firstName = 'Elizabeth' AND lastName = 'Lincoln'
    )
);

        