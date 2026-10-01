# Write your MySQL query statement below
-- select w1.id as Id from Weather as w1
--  join Weather as w2
-- on w1.recordDate = date_add(w2.recordDate, Interval 1 day)
-- where w2.temperature > w1.temperature;

-- SELECT w1.id AS id
-- FROM Weather AS w1
-- JOIN Weather AS w2
--     ON w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY)
-- WHERE w1.temperature > w2.temperature;

-- SELECT w1.id AS id
-- FROM Weather AS w1
-- JOIN Weather AS w2
--     ON w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
-- WHERE w1.temperature > w2.temperature;

SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;