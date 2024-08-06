# 1. Create a list of companies and their locations.
SELECT 
    c.name, p.city, p.country
FROM
    companies c
        JOIN
    places p ON c.place_id = p.place_id;
    
# 2. Create a list of companies and the stock exchanges they're traded on.
SELECT 
	c.name, x.name
FROM
    companies c
        JOIN
    stock_exchanges x ON c.place_id = x.place_id;
    
# 3. Create a list of shares and the currencies they're priced in.
SELECT 
    s.share_id, c.name
FROM
    shares s
        INNER JOIN
    currencies c ON s.currency_id = c.currency_id;
    
# 4. Create a list of all currency names and any shares they're used to price.
# The list should include currencies which are not used to price any share.
SELECT 
    c.name, s.share_id
FROM
    currencies c
        LEFT OUTER JOIN
    shares s ON c.currency_id = s.currency_id;
    
# 5. Find the name of any currencies that are not used to price any share.
SELECT 
    c.name, s.share_id
FROM
    currencies c
        LEFT OUTER JOIN
    shares s ON c.currency_id = s.currency_id
WHERE
    s.currency_id IS NULL;
    
# 6. Write a query that will give you the name of each company
# and the name of the currency their shares are traded in.
# HINT: join 3 tables - companies, shares and currencies.
SELECT 
    com.name, cur.name
FROM
    companies com
        INNER JOIN
    shares ON com.company_id = shares.company_id
        LEFT OUTER JOIN
    currencies cur ON shares.currency_id = cur.currency_id;

# 7. Create a list of the brokers with the stock exchanges assigned to them.
# The results should have two columns - broker's name and stock exchange name.
SELECT 
    CONCAT(b.first_name, ' ', b.last_name) 'Broker name',
    x.name 'Stock exchange name'
FROM
    brokers b
        JOIN
    broker_stock_ex bsx ON b.broker_id = bsx.broker_id
        LEFT OUTER JOIN
    stock_exchanges x ON bsx.stock_ex_id = x.stock_ex_id;

# 8. Without using the price_total column from the trades table, work out the price total for each trade_id
# (give it the alias "Base Price Total"). HINT: Finding the price of a share involves comparing its transaction
# time the share acquired a price and the time the share ended having the same price. For shares that don't have
# time_end, find their current price by comparing their transaction time with time_start only.
SELECT 
    trades.trade_id 'Trade ID',
    trades.share_amount * shares_prices.price AS 'Base Price Total'
FROM
    trades
        INNER JOIN
    shares_prices ON shares_prices.share_id = trades.share_id
WHERE
    shares_prices.time_end IS NOT NULL
        AND trades.transaction_time BETWEEN shares_prices.time_start AND shares_prices.time_end
        OR trades.transaction_time > shares_prices.time_start;
        
# 9. Amend the query produced in the previous task to include the commission for each trade (0.025 of the base price total)
# as well as the overall price total (base price total + commission).
SELECT 
    t.trade_id 'Trade ID',
    ROUND(t.share_amount * s.price,2) AS 'Base Price Total',
    ROUND(t.share_amount * s.price * 0.025,2) AS "Commission", 
    ROUND(t.share_amount * s.price + t.share_amount * s.price * 0.025,2) AS "Overall Price Total"
FROM
    trades t
        INNER JOIN
    shares_prices s ON s.share_id = t.share_id
WHERE
    s.time_end IS NOT NULL
        AND t.transaction_time BETWEEN s.time_start AND s.time_end
        OR t.transaction_time > s.time_start;
        
# Extra questions
# 1. List brokers names who work as stock exchange ID of 1.
SELECT 
    CONCAT(b.first_name, " ", b.last_name) AS "Broker name", s.stock_ex_id
FROM
    brokers b
        INNER JOIN
    broker_stock_ex bsx ON b.broker_id = bsx.broker_id
        LEFT OUTER JOIN
    stock_exchanges s ON bsx.stock_ex_id = s.stock_ex_id
WHERE
    s.stock_ex_id = 1;

# 2. List brokers names who work at NYSE.
SELECT 
    CONCAT(b.first_name, " ", b.last_name) AS "Broker name", s.symbol
FROM
    brokers b
        INNER JOIN
    broker_stock_ex bsx ON b.broker_id = bsx.broker_id
        LEFT OUTER JOIN
    stock_exchanges s ON bsx.stock_ex_id = s.stock_ex_id
WHERE
    s.symbol = "NYSE";

# 3. List the names of companies based in London.
SELECT 
    c.name, p.city
FROM
    companies c
        JOIN
    places p ON c.place_id = p.place_id
WHERE
    p.city = 'London';
    
# 4. List the places where there are no companies.
SELECT DISTINCT
    p.city, p.country
FROM
    companies c
        RIGHT OUTER JOIN
    places p ON p.place_id = c.place_id
WHERE
    c.company_id IS NULL;
    
# 5. List the names of companies and the names of currencies their shares are priced in.
SELECT 
    co.name, cu.name
FROM
    companies co
        INNER JOIN
    shares s ON co.company_id = s.company_id
        JOIN
    currencies cu ON s.currency_id = cu.currency_id;

# 6. List the names of brokers who work in the UK.
SELECT 
    CONCAT(b.first_name, ' ', b.last_name) AS 'Broker name',
    p.country
FROM
    brokers b
        INNER JOIN
    broker_stock_ex bsx ON b.broker_id = bsx.broker_id
        INNER JOIN
    stock_exchanges s ON bsx.stock_ex_id = s.stock_ex_id
        INNER JOIN
    places p ON s.place_id = p.place_id
    WHERE p.country = "United Kingdom";