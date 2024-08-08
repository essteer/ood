/* 1. Write a query which shows the average share amount for each broker_id
rounded to zero decimal places. (This query is not an inline view.)*/
SELECT 
    broker_id, ROUND(AVG(share_amount),0) 'Avg. share amount'
FROM
    trades
GROUP BY broker_id;

/* 2. Write a query which shows the lowest average share amount for any broker.
HINT: turn the query in question 1 into an inline view and select the lowest
number from that average share_amount column.*/
SELECT MIN(avg_share_amount) 'Lowest average share amount of any broker'
FROM (
SELECT 
    broker_id, ROUND(AVG(share_amount),0) AS avg_share_amount
FROM
    trades
GROUP BY broker_id) a;

/* 3. Write a query which shows the average share_amount for every broker including
those brokers who haven't made any trades. You query should return 2 columns:
broker name, average share amount.*/
SELECT 
    broker_name 'Broker name',
    avg_share_amount 'Avg. share amount'
FROM
    (SELECT 
        CONCAT(b.first_name, ' ', b.last_name) AS broker_name,
            ROUND(AVG(t.share_amount), 0) AS avg_share_amount
    FROM
        trades t
    RIGHT OUTER JOIN brokers b ON t.broker_id = b.broker_id
    GROUP BY b.broker_id) a;

/* 4. Write a query which shows the number of trades for each share. (This query
is not an inline view.)*/
SELECT 
    share_id, COUNT(*)
FROM
    trades
GROUP BY share_id;

/* 5. Write a query which shows the highest number of trades for any share. HINT:
turn the query from question 4 into an inline view and select the highest number
of trades from it.*/
SELECT 
    MAX(trades_per_share) 'Most traded share'
FROM
    (SELECT 
        share_id, COUNT(*) AS trades_per_share
    FROM
        trades
    GROUP BY share_id) a;