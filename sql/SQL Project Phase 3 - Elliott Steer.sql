# SQL Project Phase 3 - Elliott Steer - 2024-08-09
USE employees;

/* 1. Assuming every employee is a boss, display a list showing bosses
with or without employees. Order by boss name.*/
SELECT 
    t1.name AS 'Boss Name',
    COUNT(t2.employee_id) AS 'Number of Employees'
FROM
    employees t1
        LEFT JOIN
    employees t2 ON t1.employee_id = t2.boss_id
GROUP BY t1.boss_id , t1.name
ORDER BY t1.name;

/* 2. Write a query showing the name of the broker who made the trade
with the smallest share_amount. Use a simple subquery and remove any
duplicates.*/
USE trading;

SELECT 
    DISTINCT CONCAT(b.first_name, ' ', b.last_name) AS 'Broker name'
FROM
    brokers b
    INNER JOIN trades t
    ON b.broker_id = t.broker_id
WHERE
    t.share_amount = (
    SELECT MIN(t2.share_amount) FROM trades t2);

/* 3. Create a VIEW called trade_broker with the following columns (e.g. trade_id) to aliases
(e.g. 'Trade'):
a) trade table trade_id as "Trade"
b) brokers table first_name and last_name as "Broker"
c) trade table transaction_time as "Transaction Time"
d) trade table share_id as "Share"
e) trade table share_amount as "Share Amount"
f) trade table price_total as "Price Total"*/
CREATE OR REPLACE VIEW trade_broker AS
    SELECT 
        t.trade_id AS 'Trade',
        CONCAT(b.first_name, ' ', b.last_name) AS 'Broker',
        t.transaction_time AS 'Transaction Time',
        t.share_id AS 'Share',
        t.share_amount AS 'Share Amount',
        t.price_total AS 'Price Total'
    FROM
        trades t
            INNER JOIN
        brokers b ON t.broker_id = b.broker_id
;

/* 4. Using the view in the previous question, write a query that displays the brokers who have
a price total greater than £1 million.*/
SELECT DISTINCT
    `Broker`
FROM
    trade_broker
WHERE
    `Price Total` > 1000000;
    