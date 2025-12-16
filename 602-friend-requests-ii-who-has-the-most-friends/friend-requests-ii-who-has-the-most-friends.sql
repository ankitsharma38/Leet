# Write your MySQL query statement below
SELECT id, COUNT(*) AS num
FROM (
    SELECT requester_id AS id FROM requestaccepted
    UNION ALL
    SELECT accepter_id FROM requestaccepted
) AS request
GROUP BY id
ORDER BY num DESC
LIMIT 1;