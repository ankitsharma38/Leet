# Write your MySQL query statement below
select Max(num) As num
from (
    select num 
    from MyNumbers 
    Group by num 
    HAVING COUNT(*) = 1
) as singles ;