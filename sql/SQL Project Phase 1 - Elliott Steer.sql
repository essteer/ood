# SQL Project Phase 1 - Elliott Steer - 2024-08-07
USE trading;

# 1. Write a query which shows full details of any trade made by the broker with broker ID 4.
SELECT 
    *
FROM
    trades
WHERE
    broker_id = 4;
    
/* 2. Write a query showing the share_id, trade_id, price_total & share_amount for any trades 
where the price total is more than £2 million and the share amount is more than 20,000.*/
SELECT 
    share_id, trade_id, price_total, share_amount
FROM
    trades
WHERE
    price_total > 2000000
        AND share_amount > 20000;
        
# 3. Write a query which shows the broker IDs of any brokers who’ve made a trade today.
SELECT DISTINCT
    broker_id
FROM
    trades
WHERE
    DATE(transaction_time) = DATE(NOW());

/* 4. Write a query to show the share_id of each share that has been traded more than 5 times, 
along with the number of times the share has been traded. Output the share with the largest 
number of trades first, the second-largest second and so on.*/
SELECT 
    share_id 'Share ID',
    COUNT(trade_id) AS 'No. trades per share'
FROM
    trades
GROUP BY share_id
HAVING COUNT(trade_id) >= 5
ORDER BY COUNT(trade_id) DESC;
    
# 5. Write a query which shows any share IDs which have never been traded.
SELECT
    s.share_id
FROM
    shares s
        LEFT JOIN
    trades t ON s.share_id = t.share_id
WHERE
    t.trade_id IS NULL;
