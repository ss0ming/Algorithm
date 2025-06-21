-- 코드를 입력하세요
SELECT
    COUNT(DISTINCT name) cnts
FROM
    animal_ins
WHERE
    name IS NOT NULL;