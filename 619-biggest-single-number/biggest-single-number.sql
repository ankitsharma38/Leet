# Write your MySQL query statement below
-- SELECT MAX(num) AS num
-- FROM (
--     SELECT num
--     FROM MyNumbers
--     GROUP BY num
--     HAVING COUNT(*) = 1
-- ) AS singles;

select Max(num) As num
from (
    select num 
    from MyNumbers 
    Group by num 
    HAVING COUNT(*) = 1
) as singles ;