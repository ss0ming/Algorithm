-- 코드를 입력하세요
SELECT
    author.AUTHOR_ID,
    author.AUTHOR_NAME,
    book.CATEGORY,
    SUM(sales.SALES * book.PRICE) AS TOTAL_SALES
FROM
    BOOK book
    INNER JOIN AUTHOR author ON book.AUTHOR_ID = author.AUTHOR_ID
    INNER JOIN BOOK_SALES sales ON book.BOOK_ID = sales.BOOK_ID
WHERE
    sales.SALES_DATE LIKE '2022-01%'
GROUP BY
    author.AUTHOR_ID,
    book.CATEGORY
ORDER BY
    author.AUTHOR_ID ASC,
    book.CATEGORY DESC;