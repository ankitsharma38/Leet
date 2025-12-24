/* Write your T-SQL query statement below */
WITH A AS (
    SELECT id,
    visit_date,
    people,
    id - ROW_NUMBER() OVER(ORDER BY id) AS consecutive
    FROM Stadium
    WHERE people >= 100
)

SELECT id, visit_date, people
FROM A
WHERE consecutive IN (
    SELECT consecutive
    FROM A
    GROUP BY consecutive
    HAVING COUNT(id) >= 3
)