# Write your MySQL query statement below

WITH CTE AS(
    SELECT 
    product_id, 
    MONTH(order_date) as month,
    YEAR(order_date),
    unit 
    FROM Orders
    WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
),
CTE2 AS(
    SELECT 
    product_id,
    SUM(unit) as total
    FROM CTE
    GROUP BY product_id
)

SELECT product_name, total as unit
FROM CTE2 c JOIN Products p
ON c.product_id = p.product_id
WHERE total>=100