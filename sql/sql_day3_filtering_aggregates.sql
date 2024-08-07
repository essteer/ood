/* 1. List broker IDs which have an average price total of over 4,000,000.
HINT: modify your query from Module 9 Part 1.*/
SELECT 
    broker_id,
    ROUND(AVG(price_total), 2) 'Avg. Price Total Per Trade'
FROM
    trades
GROUP BY broker_id
HAVING AVG(price_total) > 4000000;

/* 2. List stock exchange IDs where each stock exchange's earliest transaction
time took place within the last 365 days. HINT: modify your query from module 9 part 2.*/
SELECT 
    stock_ex_id, MIN(transaction_time)
FROM
    trades
GROUP BY stock_ex_id
HAVING MIN(transaction_time) > DATE_ADD(CURDATE(), INTERVAL -1 YEAR);

/* 3. List currency IDs used to price 4 or more shares.
HINT: modify your query from module 9 part 3.*/
SELECT 
    c.currency_id,
    COALESCE(COUNT(s.share_id), 0) 'No. Shares Priced in Currency'
FROM
    currencies c
        LEFT OUTER JOIN
    shares s ON c.currency_id = s.currency_id
GROUP BY c.currency_id
HAVING COUNT(s.share_id) >= 4;

/* 4. List share IDs with a total share amount above 100,000. HINT: modify
your query from module 9 part 4.*/
SELECT 
    share_id, SUM(share_amount) 'Total Share Amount'
FROM
    trades
GROUP BY share_id
HAVING SUM(share_amount) > 100000
ORDER BY SUM(share_amount) DESC;

/* 5. List place IDs with more than 2 companies. HINT: find the number of 
companies for each place ID and then filter your results.*/
SELECT 
    place_id
FROM
    companies
GROUP BY place_id
HAVING COUNT(company_id) > 2;

/* 6. List share IDs whose highest price total is above 1 million. HINT: find
the highest price total for each share ID and then filter your results.*/
SELECT share_id FROM trades GROUP BY share_id HAVING MAX(price_total) > 1000000;

/* 7. List share IDs which have been traded more than twice by broker ID 1.
HINT: use WHERE and HAVING.*/
SELECT 
    share_id
FROM
    trades
WHERE
    broker_id = 1
GROUP BY share_id
HAVING COUNT(trade_id) > 2;

/* 8. List share IDs which have more than 5 trades with a price_total above
1 million. HINT: use WHERE and HAVING.*/
SELECT 
    share_id
FROM
    trades
WHERE
    price_total > 1000000
GROUP BY share_id
HAVING COUNT(trade_id) > 5;

SELECT * FROM trades ORDER BY share_id, price_total DESC;
