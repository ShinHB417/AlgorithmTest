-- 코드를 입력하세요
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR > 8 AND HOUR < 20
ORDER BY HOUR(DATETIME)