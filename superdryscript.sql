CREATE DATABASE IF NOT EXISTS superdrylaundry;
USE superdrylaundry;

CREATE TABLE IF NOT EXISTS customers (
	id VARCHAR(64) NOT NULL PRIMARY KEY,
	firstname VARCHAR(64) NOT NULL,
	lastname VARCHAR(64) NOT NULL,
	loc VARCHAR(64) NOT NULL,
	kilos INT NOT NULL);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES ('20180001', 'Bloom', 'Maninang', 'Tayuman, Manila', 8);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES ('20180002', 'Ody', 'Grumpy Cat', 'Tayuman, Manila', 5);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES ('20180003', 'Migo', 'Aquino', 'Robinsons Homes, Antipolo', 10);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES ('20180004', 'Jack', 'Hoba', 'Washington, Makati', 15);
INSERT INTO customers(id, firstname, lastname, loc, kilos) VALUES ('20180005', 'Dreingineer', 'Andrei', 'Washington, Makati', 7);

CREATE TABLE IF NOT EXISTS locations (
	zip INT NOT NULL PRIMARY KEY,
	street VARCHAR(64) NOT NULL,
	brgy VARCHAR(64) NOT NULL,
	units INT NOT NULL);
INSERT INTO locations(zip, street, brgy, units) VALUES (1940, 'Tayuman Street','Brgy93',5);
INSERT INTO locations(zip, street, brgy, units) VALUES (1870, 'Ortigas Extension','San Jose',4);
INSERT INTO locations(zip, street, brgy, units) VALUES (1230, 'Washington Street','PioDelPilar',6);

CREATE TABLE IF NOT EXISTS services (
	ponum INT NOT NULL AUTO_INCREMENT,
	branch INT NOT NULL,
	price INT NOT NULL,
	 