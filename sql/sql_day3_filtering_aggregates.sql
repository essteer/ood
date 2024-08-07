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

# ===============
# Extra questions
# ===============

# 1. List stock_ex_ids with an average share amount above 1000 in the last 60 days.
SELECT 
    stock_ex_id
FROM
    trades
WHERE
    transaction_time >= DATE_ADD(CURDATE(), INTERVAL - 60 DAY)
GROUP BY stock_ex_id
HAVING AVG(share_amount) > 1000;

# 2. Modify your query to show the names of the stock exchanges.
SELECT 
    ex.name, t.stock_ex_id
FROM
    trades t
        LEFT JOIN
    stock_exchanges ex ON t.stock_ex_id = ex.stock_ex_id
WHERE
    t.transaction_time >= DATE_ADD(CURDATE(), INTERVAL - 60 DAY)
GROUP BY t.stock_ex_id
HAVING AVG(t.share_amount) > 1000;

/*3. List the broker_ids with the lowest share amount on stock_ex_id 1
that is greater than 5,000.*/
SELECT DISTINCT
    broker_id
FROM
    trades
WHERE
    share_amount = (SELECT 
            MIN(share_amount)
        FROM
            trades
        WHERE
            stock_ex_id = 1 AND share_amount > 5000);

# This is the model answer - a different interpretation of the question! Badly worded.
SELECT 
    broker_id
FROM
    trades
WHERE
    stock_ex_id = 1
GROUP BY broker_id
HAVING MIN(share_amount) > 5000;

# 4. Modify your query to show the names of the brokers.
SELECT DISTINCT
    t.broker_id 'Broker ID',
    CONCAT(b.first_name, ' ', b.last_name) 'Broker Name'
FROM
    trades t
        LEFT JOIN
    brokers b ON t.broker_id = b.broker_id
WHERE
    t.share_amount = (SELECT 
            MIN(share_amount)
        FROM
            trades
        WHERE
            stock_ex_id = 1 AND share_amount > 5000);
            
# Model answer for their interpretation:
SELECT 
    CONCAT(b.first_name, ' ', b.last_name) AS broker
FROM
    trades t
        INNER JOIN
    brokers b ON b.broker_id = t.broker_id
WHERE
    t.stock_ex_id = 1
GROUP BY CONCAT(b.first_name, ' ', b.last_name)
HAVING MIN(share_amount) > 5000;

# 5. List share_ids which broker 1 has traded more than 10 times.
SELECT 
    share_id
FROM
    trades
WHERE
    broker_id = 1
GROUP BY share_id
HAVING COUNT(trade_id) > 10;

# 6. List the names of companies in London with an average share price above 150.
SELECT 
    co.name
FROM
    companies co
        INNER JOIN
    places pl ON co.place_id = pl.place_id
        INNER JOIN
    shares sh ON co.company_id = sh.company_id
        INNER JOIN
    shares_prices sp ON sh.share_id = sp.share_id
WHERE
    pl.city = 'London'
GROUP BY sp.share_id
HAVING AVG(price) > 150;

/*7. Display the name of the broker who has the highest average share amount.
HINT: use a subquery in your HAVING filter. The inner query should combine 2
aggregate functions to find the highest average share amount for a broker_id.*/
SELECT 
    CONCAT(b.first_name, ' ', b.last_name) 'Broker Name', AVG(share_amount)
FROM
    brokers b
        INNER JOIN
    trades t ON b.broker_id = t.broker_id
GROUP BY CONCAT(b.first_name, ' ', b.last_name)
HAVING ROUND(AVG(share_amount),2) = (SELECT 
        ROUND(MAX(avg_share_amount),2)
    FROM
    (SELECT AVG(share_amount) AS avg_share_amount FROM
        trades
    GROUP BY broker_id) avg_share_amounts);

/* 8. List share_id whose lowest share amount is greater than the highest share
amount for share_id 4. HINT: use a subquery in your HAVING filter.*/
SELECT 
    share_id, MIN(share_amount)
FROM
    trades
GROUP BY share_id
HAVING MIN(share_amount) > (SELECT 
        MAX(share_amount)
    FROM
        trades
    GROUP BY share_id
    HAVING share_id = 4);