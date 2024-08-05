CREATE TABLE 
  location
    (
      place_id	 INT PRIMARY KEY,
      city 		 VARCHAR(50),
      country 	 VARCHAR(50)
    )
;

CREATE TABLE client
(
  client_id			INT PRIMARY KEY,
  client_name 		VARCHAR(50),
  place_id 			INT,
  CONSTRAINT clent_places_fk
  FOREIGN KEY(place_id) REFERENCES location(place_id)
);

CREATE TABLE contractor
(
  contractor_id		INT PRIMARY KEY,
  first_name 		VARCHAR(50),
  last_name 		VARCHAR(50),
  client_id 		INT,
  CONSTRAINT client_contr_fk
  FOREIGN KEY(client_id) REFERENCES client(client_id)
);


INSERT INTO location (
	place_id,
	city,
	country
) VALUES (
	1,
	'London',
	'UK'
);

INSERT INTO location (
	place_id,
	city,
	country
) VALUES (
	2,
	'New York',
	'USA'
);

INSERT INTO location (
	place_id,
	city,
	country
) VALUES (
	3,
	'Paris',
	'France'
);

INSERT INTO location (
	place_id,
	city,
	country
) VALUES (
	4,
	'Tokyo',
	'Japan'
);

INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	1,
	'BA',
	1
);


INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	2,
	'EDF',
	3
);

INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	3,
	'Google',
	2
);
  
INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	4,
	'IBM',
	2
);

INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	5,
	'Tesco',
	1
);

INSERT INTO client(
	client_id,
	client_name,
	place_id
) VALUES (
	6,
	'Toyota',
	4
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	1,
	'Andrew',
  'Wallace',
	4
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	2,
	'Andre',
  'Sinclair',
	3
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	3,
	'John',
  'Smith',
	1
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	4,
	'Parker',
  'Hamilton',
	2
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	5,
	'James',
  'Washington',
	3
);

INSERT INTO contractor(
	contractor_id,
	first_name,
	last_name,
  client_id
) VALUES (
	6,
	'Paul',
  'Piper',
	2
);

# Toyota has moved their headquarters to the same location as IBM.
# Write an UPDATE statement which will update the location of Toyota in the companies table.
UPDATE client 
SET 
    place_id = 2
WHERE
    client_id = 6;
    
SELECT * FROM client;

# EDF has gone into liquidation. 
# Write a DELETE statement to remove them from the database 
# and delete any contractors that works for EDF. 
# You will need to do this in a specific order or you may receive an error message.
DELETE FROM contractor 
WHERE
    client_id = (SELECT 
        client_id
    FROM
        client
    
    WHERE
        client_name = 'EDF')
;

SELECT * FROM client;

DELETE FROM client 
WHERE
    client_id = 2;