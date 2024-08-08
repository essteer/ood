/* 1. Use a correlated subquery to show the trade_id of the earliest transaction_time for each stock_exchange.
The output should have 3 columns: stock_ex_id, trade_id, transaction_time.*/
SELECT 
    t.stock_ex_id, t.trade_id, t.transaction_time
FROM
    trades t
WHERE
    t.transaction_time = (SELECT 
            MIN(t2.transaction_time)
        FROM
            trades t2
        WHERE
            t2.stock_ex_id = t.stock_ex_id)
;

/* 2. Use a correlated subquery to show the broker with the highest price total for each stock exchange.
The output should have 3 columns: stock_ex_id, broker_id, price_total.*/
SELECT 
    t.stock_ex_id, t.broker_id, t.price_total
FROM
    trades t
WHERE
    price_total IN (SELECT 
            MAX(t2.price_total)
        FROM
            trades t2
        WHERE
            t2.stock_ex_id = t.stock_ex_id);
            
/* 3. Modify your query from Question 1 to show the name of the stock exchange instead of the stock_ex_id.
HINT: join the stock exchanges table to the trades table in the outer query.*/
SELECT 
    s.name, t.trade_id, t.transaction_time
FROM
    trades t
        JOIN
    stock_exchanges s ON t.stock_ex_id = s.stock_ex_id
WHERE
    t.transaction_time = (SELECT 
            MIN(t2.transaction_time)
        FROM
            trades t2
        WHERE
            t2.stock_ex_id = t.stock_ex_id)
;

/* 4. Modify your query from Question 2 to show the name of the stock exchange and the name of the broker
instead of their IDs.*/
SELECT 
    s.name,
    CONCAT(b.first_name, ' ', b.last_name) 'Broker name',
    t.price_total
FROM
    trades t
        JOIN
    stock_exchanges s ON t.stock_ex_id = s.stock_ex_id
    JOIN brokers b on t.broker_id = b.broker_id
WHERE
    price_total IN (SELECT 
            MAX(t2.price_total)
        FROM
            trades t2
        WHERE
            t2.stock_ex_id = t.stock_ex_id);

/* 5. Use a correlated subquery to show the broker with the lowest share amount for each month.
The output should have 3 columns: month, broker_id, share_amount. HINT: use the TO_CHAR function
to extract the month from the transaction_time column.*/
SELECT 
    MONTHNAME(t.transaction_time) AS month,
    t.broker_id,
    t.share_amount
FROM
    trades t
WHERE
    t.share_amount = (SELECT 
            MIN(t2.share_amount)
        FROM
            trades t2
        WHERE
            MONTH(t.transaction_time) = MONTH(t2.transaction_time));
            
# 6. Modify the previous query to show the name of the broker instead of the broker_id.
SELECT 
    MONTHNAME(t.transaction_time) AS month,
    CONCAT(b.first_name, ' ', b.last_name) AS 'Broker name',
    t.share_amount
FROM
    trades t
        INNER JOIN
    brokers b ON t.broker_id = b.broker_id
WHERE
    t.share_amount = (SELECT 
            MIN(t2.share_amount)
        FROM
            trades t2
        WHERE
            MONTH(t.transaction_time) = MONTH(t2.transaction_time))
ORDER BY MONTHNAME(t.transaction_time);