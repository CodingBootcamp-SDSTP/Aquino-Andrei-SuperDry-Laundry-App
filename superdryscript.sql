CREATE DATABASE IF NOT EXISTS superdrylaundrydb;
USE superdrylaundrydb;

CREATE TABLE IF NOT EXISTS customers (
	id VARCHAR(64) NOT NULL PRIMARY KEY,
	firstname VARCHAR(64) NOT NULL,
	lastname VARCHAR(64) NOT NULL,
	loc VARCHAR(64) NOT NULL,
	kilos INT NOT NULL
	);

INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180001, 'Bloom', 'Maninang', 'Tayuman, Manila', 8);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180002, 'Ody', 'Grumpy Cat', 'Tayuman, Manila', 5);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180003, 'Migo', 'Aquino', 'Robinsons Homes, Antipolo', 10);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180004, 'Jack', 'Hoba', 'Washington, Makati', 15);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180005, 'Dreingineer', 'Andrei', 'Washington, Makati', 7);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180006, 'Barbs', 'Barcenas', 'The Netherlands', 6);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES (20180007, 'Raphael', 'Barcenas', 'Dasmarinas', 8);

DROP TABLE IF EXISTS locations;
CREATE TABLE IF NOT EXISTS locations (
	zip INT NOT NULL PRIMARY KEY,
	street VARCHAR(64) NOT NULL,
	brgy VARCHAR(64) NOT NULL,
	units INT NOT NULL
	);

INSERT INTO locations(zip, street, brgy, units) VALUES (1940, 'Tayuman Street','Brgy93',5);
INSERT INTO locations(zip, street, brgy, units) VALUES (1870, 'Ortigas Extension','San Jose',4);
INSERT INTO locations(zip, street, brgy, units) VALUES (1230, 'Washington Street','PioDelPilar',6);

DROP TABLE IF EXISTS services;
CREATE TABLE IF NOT EXISTS services (
	id INT AUTO_INCREMENT,
	PRIMARY KEY(id),
	custNum VARCHAR(64) NOT NULL,
	date INT NOT NULL,
	branch INT NOT NULL,
	price INT NOT NULL,
	service VARCHAR(64) NOT NULL,
	FOREIGN KEY(custNum) REFERENCES customers(id),
	FOREIGN KEY(branch) REFERENCES locations(zip)
	);

INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180002), 20180601, (SELECT zip FROM locations WHERE zip=1940), 70, 'Dry and Fold');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180004), 20180602, (SELECT zip FROM locations WHERE zip=1230), 220, 'Wash, Dry and Fold');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180005), 20180603, (SELECT zip FROM locations WHERE zip=1230), 100, 'Wash and Dry');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180001), 20180601, (SELECT zip FROM locations WHERE zip=1940), 100, 'Wash and Dry');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180003), 20180602, (SELECT zip FROM locations WHERE zip=1870), 100, 'Wash and Dry');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180006), 20180604, (SELECT zip FROM locations WHERE zip=1940), 120, 'Wash, Dry and Fold');
INSERT INTO services (custNum, date, branch, price, service) VALUES ((SELECT id FROM customers WHERE id=20180007), 20180604, (SELECT zip FROM locations WHERE zip=1230), 120, 'Wash, Dry and Fold');
