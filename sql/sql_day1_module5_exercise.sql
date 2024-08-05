# 1. What currencies are available to price shares in?
SELECT name FROM currencies;

# 2. What trades have been made this month?
SELECT 
    *
FROM
    trades
WHERE
    MONTH(transaction_time) = MONTH(CURDATE())
        AND YEAR(transaction_time) = YEAR(CURDATE());

# 3. What companies have their HQ in New York (place_id 3)?
SELECT 
    company_id, name, place_id
FROM
    companies
WHERE
    place_id = 3;
    
# 4. What is the symbol used for the London Stock Exchange?
SELECT 
    *
FROM
    stock_exchanges
WHERE
    name = 'London Stock Exchange'
;
# 5. What cities are associated with France?
SELECT city FROM places WHERE country = "France";
# 6. There are two brokers called John, what are their last names?
SELECT broker_id, last_name FROM brokers WHERE first_name = "John";
# 7. What trades have been made in the last 7 days?
SELECT * FROM trades WHERE transaction_time > DATE_ADD(NOW(), INTERVAL -7 DAY);
# 8. List the broker IDs who work at the stock exchange ID of 1.
SELECT * FROM broker_stock_ex WHERE stock_ex_id = 1;
# 9. Display the company that has a company ID of 2.
SELECT * FROM companies WHERE company_id = 2;
# 10. Display the currency that has a currency ID of 1.
SELECT * FROM currencies WHERE currency_id = 1;
# 11. Display the name of the stock exchange with the symbol TSE.
SELECT name FROM stock_exchanges WHERE symbol = "TSE";
# 12. Display the last name of the broker whose ID is 2.
SELECT last_name FROM brokers WHERE broker_id = 2;
# 13. List the trade IDs and price totals of the trades which have
# taken place at the stock exchange of ID 3 and share_amount greater than 20000.
SELECT 
    trade_id, price_total
FROM
    trades
WHERE
    stock_ex_id = 3 AND share_amount > 20000;
# 14. What are the broker IDs for the brokers working at stock exchange 2?
# Sort the broker IDs into ascending order.
SELECT broker_id, stock_ex_id FROM broker_stock_ex WHERE stock_ex_id = 2 ORDER BY broker_id ASC;
# 15. Which currencies have the word "British" in them?
SELECT * FROM currencies WHERE name LIKE "%British%";
# 16. Which stock exchanges contain "SE" in their symbol?
# What are their full names? Sort them into descending order.
SELECT 
    *
FROM
    stock_exchanges
WHERE
    symbol LIKE '%SE%'
ORDER BY name DESC;
# 17. Which share IDs have their prices between 400 and 500?
SELECT DISTINCT share_id FROM shares_prices WHERE price >= 400 AND price <= 500;
# 18. Which shares were traded in the last year? (I.e. since this day last year)
SELECT DISTINCT share_id FROM shares_prices WHERE time_end > DATE_ADD(NOW(), INTERVAL -1 YEAR);
# 19. Which trade IDs took place in this calendar year (i.e. since 1 January)?
SELECT trade_id, transaction_time FROM trades WHERE DATE(transaction_time) > "2024-01-01";
# 20. Display full details of all trades which took place last year.
SELECT * FROM trades WHERE YEAR(transaction_time) = YEAR(DATE_ADD(NOW(), INTERVAL -1 YEAR));
# 21. Display full details of all trades which took place in the previous quarter.
SELECT 
    *
FROM
    trades
WHERE
    QUARTER(transaction_time) = QUARTER(DATE_ADD(NOW(), INTERVAL -1 QUARTER))
        AND YEAR(transaction_time) = YEAR(DATE_ADD(NOW(), INTERVAL -1 QUARTER));
# 22. Which trade IDs have had price totals of over 1,000,000 in the last 90 days?
SELECT 
    trade_id, price_total, transaction_time
FROM
    trades
WHERE
    price_total > 1000000
        AND DATE(transaction_time) >= DATE(DATE_ADD(CURDATE(), INTERVAL - 90 DAY));
# 23. Calculate and display the cost per share for each trade.
SELECT 
    trade_id, price_total / share_amount
FROM
    trades;