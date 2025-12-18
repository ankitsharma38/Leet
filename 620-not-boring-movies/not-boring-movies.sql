-- # Write your MySQL query statement below
-- SELECT * FROM cinema 
-- WHERE id%2=1 and description!='boring' 
-- ORDER BY rating DESC;


SELECT 
*
FROM Cinema
WHERE id % 2 =1 AND description <> "boring"
ORDER BY rating DESC;