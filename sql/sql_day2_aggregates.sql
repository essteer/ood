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
    c.currency_id, COALESCE(COUNT(s.share_id), 0) "No. Shares Priced in Currency"
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

# Extra questions
# 1. How many trades have been made on NYSE?
SELECT 
    x.symbol, COUNT(t.trade_id)
FROM
    stock_exchanges x
        INNER JOIN
    trades t ON x.stock_ex_id = t.stock_ex_id
WHERE
    x.symbol = 'NYSE'
GROUP BY x.stock_ex_id;

# 2. How many shares have been traded on the LSE (total share_amount)?
SELECT 
    x.symbol 'Stock Exchange',
    SUM(t.share_amount) 'Total Shares Traded'
FROM
    stock_exchanges x
        INNER JOIN
    trades t ON x.stock_ex_id = t.stock_ex_id
WHERE
    x.symbol = 'LSE'
GROUP BY x.stock_ex_id;

# 3. How many companies based in the UK have names starting with B?
SELECT 
    COUNT(company_id) 'No. UK Companies Beginning with \'B\''
FROM
    companies c
        JOIN
    places p ON c.place_id = p.place_id
WHERE
    p.country = 'United Kingdom'
        AND c.name LIKE 'B%';

# 4. Show the number of trades made by any broker in the last 10 days.
# Show two columns: broker name and number of trades.
SELECT 
    CONCAT(b.first_name, ' ', b.last_name), COUNT(trade_id)
FROM
    brokers b
        INNER JOIN
    trades t ON b.broker_id = t.broker_id
WHERE b.broker_id = 1 AND t.transaction_time >= DATE_ADD(CURDATE(), INTERVAL -10 DAY);

# 5. Show the total share amount for any company in the last 90 days.
# The result should have two columns: company name and total share amount.
SELECT 
    c.name 'Company Name',
    SUM(t.share_amount) 'Total Share Amount'
FROM
    companies c
        INNER JOIN
    shares s ON c.company_id = s.company_id
        INNER JOIN
    trades t ON s.share_id = t.share_id
WHERE
    c.name = 'Tesco';

# 6. Create a list showing the number of companies per city.
# The result should have two columns: city and number of companies.
SELECT 
    p.city, COUNT(c.company_id) "No. Companies"
FROM
    places p
        LEFT OUTER JOIN
    companies c ON p.place_id = c.place_id
GROUP BY p.place_id;

# 7. Find the average price total for each company. The results should
# have two columns: company name and average price total. Round the average
# to 0 decimal places.
SELECT 
    c.name, ROUND(AVG(t.price_total), 0) "Average Price Total"
FROM
    companies c
        INNER JOIN
    shares s ON c.company_id = s.company_id
        INNER JOIN
    trades t ON s.share_id = t.share_id
GROUP BY c.name;  


# 8. Create a list showing the name of each broker and the number of stock exchanges
# that they trade on. The result should have two columns: broker name, number of exchanges.
SELECT 
    CONCAT(b.first_name, ' ', b.last_name) 'Broker Name',
    COUNT(bsx.stock_ex_id) 'No. Exchanges Trading On'
FROM
    brokers b
        INNER JOIN
    broker_stock_ex bsx ON b.broker_id = bsx.broker_id
GROUP BY bsx.broker_id;

# 9. Create a list of names of currencies and the number of shares each currency is used to price.
# The result should have two columns: currency name, number of shares.
SELECT
    c.name "Currency", COALESCE(COUNT(s.share_id), 0) "No. Shares Priced in Currency"
FROM
    currencies c
        LEFT OUTER JOIN
    shares s ON c.currency_id = s.currency_id
GROUP BY c.currency_id;

# 10. Create a list showing the average of share price per month per company. The result should
# have three columns: company name, month and average price (rounded to 2 decimal places). Make sure
# the results are ordered by the company name and the month.
SELECT 
    c.name,
    MONTH(NOW()) AS month,
    ROUND(AVG(sp.price), 2) AS 'Average share price'
FROM
    companies c
        INNER JOIN
    shares s ON c.company_id = s.company_id
        INNER JOIN
    shares_prices sp ON s.share_id = sp.share_id
GROUP BY c.name , MONTH(NOW())
ORDER BY c.name , MONTH(NOW());