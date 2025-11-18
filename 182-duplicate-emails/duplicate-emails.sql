# Write your MySQL query statement below
Select email FROM Person GROUP BY email having COUNT(email) > 1;