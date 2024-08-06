# 1. Write a query which shows share IDs traded by broker 1.
SELECT DISTINCT
    t.broker_id, t.share_id
FROM
    trades t
WHERE
    t.broker_id = 1
ORDER BY share_id;

# 2. Write a query which shows share IDs traded on stock exchange 3.
SELECT DISTINCT
    t.stock_ex_id, t.share_id
FROM
    trades t
WHERE
    t.stock_ex_id = 3
ORDER BY share_id;

# 3. Use a set function to combine the two previous queries to show share IDs
# which were traded by broker 1 or traded on stock exchange 3 (or both).
SELECT DISTINCT
    t.broker_id, t.stock_ex_id, t.share_id
FROM
    trades t
WHERE
    t.broker_id = 1
UNION
SELECT DISTINCT
    t.broker_id, t.stock_ex_id, t.share_id
FROM
    trades t
WHERE
    t.stock_ex_id = 3
ORDER BY share_id;

# 4. Use a set function to show share IDs which were traded by broker 1
# but not traded on stock exchange 3.
SELECT DISTINCT
    t.broker_id, t.stock_ex_id, t.share_id
FROM
    trades t
        LEFT OUTER JOIN
    trades t2 ON t.trade_id = t2.trade_id
WHERE
    t.broker_id = 1 AND t.stock_ex_id != 3;

# 5. Use a set function to show share IDs which were traded by broker 1 on stock exchange 3.
SELECT 
    broker_id, stock_ex_id, share_id
FROM
    trades
WHERE
    broker_id = 1 AND stock_ex_id = 3;