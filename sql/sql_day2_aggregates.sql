# 1. Show the average price total for each broker. The results should have two columns:
# broker_id and average price total
SELECT 
    broker_id, ROUND(AVG(price_total), 2)
FROM
    trades
GROUP BY broker_id;

# 2. Find the date of the earliest trade for each stock exchange. The results should have
# two columns stock_ex_id and transaction_time.
SELECT 
    stock_ex_id, MIN(transaction_time)
FROM
    trades
GROUP BY stock_ex_id;

# 3. Show the number of shares priced in each currency. The results should have two columns:
# currency_id and number of shares priced in that currency.
SELECT
    c.name "Currency", COALESCE(COUNT(s.share_id), 0) "No. Shares Priced in Currency"
FROM
    currencies c
        LEFT OUTER JOIN
    shares s ON c.currency_id = s.currency_id
GROUP BY c.currency_id;

# 4. Show the total share amount for each share. The results should have two columns:
# share_id and total share amount.
SELECT 
    share_id, SUM(share_amount) 'Total Share Amount'
FROM
    trades
GROUP BY share_id
ORDER BY SUM(share_amount) DESC;