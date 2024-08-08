-- 1.	Show full details of all shares reaching high point (peak) prices.
SELECT sp1.share_id, 
       sp1.time_start, 
       sp1.time_end, 
       sp1.price
FROM shares_prices sp1
-- share where the price is greater than the price of the share with the same share_id and the latest earlier time_start
WHERE sp1.price >= (SELECT sp2.price
                   FROM shares_prices sp2
                   WHERE sp2.share_id = sp1.share_id
                   AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
-- share where the price is greater than the price of the share with the same share_id and the earliest later time_start
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the earliest time_start 
-- if its price is greater than the price of the share with the same share_id and the earliest later time_start
OR sp1.time_start = (SELECT MIN(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the latest time_start 
-- if its price is greater than the price of the share with the same share_id and the latest earlier time_start
OR sp1.time_start = (SELECT MAX(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
ORDER BY sp1.share_id, sp1.time_start, sp1.time_end
;


-- 2.	Show full details of all shares reaching low point prices.
SELECT sp1.share_id, 
       sp1.time_start, 
       sp1.time_end, 
       sp1.price
FROM shares_prices sp1
-- share where the price is lower than the price of the share with the same share_id and the latest earlier time_start
WHERE sp1.price <= (SELECT sp2.price
                   FROM shares_prices sp2
                   WHERE sp2.share_id = sp1.share_id
                   AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
-- share where the price is lower than the price of the share with the same share_id and the earliest later time_start
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the earliest time_start 
-- if its price is lower than the price of the share with the same share_id and the earliest later time_start
OR sp1.time_start = (SELECT MIN(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the latest time_start 
-- if its price is lower than the price of share with the same share_id and the latest earlier time_start
OR sp1.time_start = (SELECT MAX(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
ORDER BY sp1.share_id, sp1.time_start, sp1.time_end
;


-- 3.	Show full details of all shares reaching both peak and low point prices.
SELECT sp1.share_id, 
       sp1.time_start, 
       sp1.time_end, 
       sp1.price
FROM shares_prices sp1
-- share where the price is greater than the price of the share with the same share_id and the latest earlier time_start
WHERE sp1.price >= (SELECT sp2.price
                   FROM shares_prices sp2
                   WHERE sp2.share_id = sp1.share_id
                   AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
-- share where the price is greater than the price of the share with the same share_id and the earliest later time_start
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the earliest time_start 
-- if its price is greater than the price of the share with the same share_id and the earliest later time_start
OR sp1.time_start = (SELECT MIN(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the latest time_start 
-- if its price is greater than the price of the share with the same share_id and the latest earlier time_start
OR sp1.time_start = (SELECT MAX(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price >= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
UNION
SELECT sp1.share_id, 
       sp1.time_start, 
       sp1.time_end, 
       sp1.price
FROM shares_prices sp1
-- share where the price is lower than the price of the share with the same share_id and the latest earlier time_start
WHERE sp1.price <= (SELECT sp2.price
                   FROM shares_prices sp2
                   WHERE sp2.share_id = sp1.share_id
                   AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
-- share where the price is lower than the price of the share with the same share_id and the earliest later time_start
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the earliest time_start 
-- if its price is lower than the price of the share with the same share_id and the earliest later time_start
OR sp1.time_start = (SELECT MIN(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_start) = DATE(DATE_ADD(sp1.time_end,INTERVAL +1 DAY)))
-- include the share with the same share_id and the latest time_start 
-- if its price is lower than the price of the share with the same share_id and the latest earlier time_start
OR sp1.time_start = (SELECT MAX(sp2.time_start)
                     FROM shares_prices sp2
                     WHERE sp2.share_id = sp1.share_id)
AND sp1.price <= (SELECT sp2.price
                 FROM shares_prices sp2
                 WHERE sp2.share_id = sp1.share_id
                 AND DATE(sp2.time_end) = DATE(DATE_ADD(sp1.time_end,INTERVAL -1 DAY)))
;
