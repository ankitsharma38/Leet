# Write your MySQL query statement below
SELECT c.name AS Customers
FROM customers AS c
LEFT JOIN orders AS o ON o.customerId=c.id
WHERE o.id is NULL