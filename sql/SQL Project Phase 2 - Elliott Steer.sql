# SQL Project Phase 2 - Elliott Steer - 2024-08-08
USE trading;

# 1. Write a query which shows the highest price total.
SELECT 
    MAX(price_total) 'Highest price total'
FROM
    trades;

/* 2. Write a query which shows the highest and lowest price totals in the trades table.
The results should be displayed in a single column.*/
SELECT DISTINCT
    price_total 'Highest and lowest price totals'
FROM
    trades
WHERE
    price_total = (SELECT 
            MAX(price_total)
        FROM
            trades)
        OR price_total = (SELECT 
            MIN(price_total)
        FROM
            trades);
            
/* 3. Write a query which shows the average share price for each share ID - use the shares_prices table.
Round the averages to zero decimal places and order by the share_id.*/
SELECT 
    share_id 'Share ID', ROUND(AVG(price), 0) 'Avg. share price'
FROM
    shares_prices
GROUP BY share_id
ORDER BY share_id;

/* 4. Write a query which shows the trade_id with the lowest price_total for each share_id and order it
by price_total. Also display the broker_id and broker_name (first name and last name under the column
"Broker Name").*/
SELECT 
    t.trade_id 'Trade ID with lowest price total per share ID',
    t.price_total 'Price total',
    t.share_id 'Share ID',
    t.broker_id 'Broker ID',
    CONCAT(b.first_name, ' ', b.last_name) AS 'Broker Name'
FROM
    trades t
        INNER JOIN
    brokers b ON t.broker_id = b.broker_id
WHERE
    t.price_total IN (SELECT 
            MIN(t2.price_total)
        FROM
            trades t2
        WHERE
            t2.share_id = t.share_id)
ORDER BY t.price_total;

# 5. Write a query which shows any share IDs where broker 1 has made more than 2 trades.
SELECT 
    share_id 'Share IDs with > 2 trades by Broker 1',
    COUNT(trade_id) 'No. Trades by Broker 1'
FROM
    trades t
WHERE
    broker_id = 1
GROUP BY share_id
HAVING COUNT(trade_id) > 2
ORDER BY share_id;