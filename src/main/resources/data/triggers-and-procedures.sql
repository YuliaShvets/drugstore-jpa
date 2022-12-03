USE shvets_db;

DROP TRIGGER IF EXISTS check_column_with_two_zeros;
DROP TRIGGER IF EXISTS check_country_name;
DROP TRIGGER IF EXISTS log_with_date;
DROP FUNCTION IF EXISTS find_average_price;
DROP PROCEDURE IF EXISTS add_country;
DROP PROCEDURE IF EXISTS add_ten_drugstores;
DROP PROCEDURE IF EXISTS  add_new_db;
DROP TRIGGER IF EXISTS if_id_is_unique;
DROP TRIGGER IF EXISTS if_can_be_updated;
DROP TRIGGER IF EXISTS if_can_be_deleted;


DELIMITER //

CREATE TRIGGER check_column_with_two_zeros
BEFORE INSERT 
ON city
FOR EACH ROW 
BEGIN 
	IF(new.Name REGEXP("00$")) THEN 
    SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Name can't end with two 0";
	END IF;

END//

CREATE TRIGGER check_country_name
BEFORE INSERT
ON country
FOR EACH ROW
BEGIN 
	IF(new.Name REGEXP("Russia")) THEN
     SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "This country doesn't exist";
	END IF;
    
END//

CREATE TRIGGER log_with_date
AFTER INSERT
ON city
FOR EACH ROW
BEGIN
INSERT INTO city_log (city_id, city_name, country, date) VALUES (new.Id, new.Name, new.Country_name, NOW());

END//

CREATE FUNCTION find_average_price() RETURNS FLOAT DETERMINISTIC
BEGIN
RETURN (SELECT AVG(price_in_dollars) FROM drug);

END//

SELECT find_average_price() AS price//

CREATE PROCEDURE add_country(IN name varchar(25))
BEGIN
	INSERT INTO country VALUES(name);
END//

CREATE PROCEDURE add_ten_drugstores(IN name varchar(25))
BEGIN
	DECLARE count int;
SET count = 1;
    addDrugstore: LOOP
		IF count < 10 THEN LEAVE addDrugstore;
        END IF;
			INSERT INTO drugstore(name) VALUES(CONCAT(name, "-", count));
        SET count = count + 1;
	END LOOP;
END//

CREATE PROCEDURE add_new_db()
BEGIN
    DECLARE isDone BOOLEAN DEFAULT FALSE;
	DECLARE d_name char(45);
    DECLARE drugstore_cursor CURSOR 
    FOR SELECT name FROM drugstore;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET isDone = TRUE;
    OPEN drugstore_cursor;
    myLoop: LOOP
	FETCH drugstore_cursor INTO d_name;
	IF isDone=TRUE THEN LEAVE myLoop;
	END IF;
	SET @temp_query=CONCAT('CREATE DATABASE ',d_name);
	PREPARE myquery FROM @temp_query;
	EXECUTE myquery;
	DEALLOCATE PREPARE myquery;
	END LOOP;
	CLOSE drugstore_cursor;
END //

CREATE TRIGGER if_id_is_unique
	BEFORE INSERT 
    ON country
    FOR EACH ROW 
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
	DECLARE c_name char(45);
    DECLARE country_cursor CURSOR 
    FOR SELECT name FROM country;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET isDone = TRUE;
    OPEN country_cursor;
    myLoop: LOOP
	FETCH country_cursor INTO c_name;
	IF isDone=TRUE THEN LEAVE myLoop;
	END IF;
    IF new.Name = c_name THEN 
		SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Country already exists";
        END IF;
	END LOOP;
CLOSE country_cursor;

END//

CREATE TRIGGER if_can_be_updated
	BEFORE UPDATE 
    ON country
    FOR EACH ROW 
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
	DECLARE c_name char(45);
    DECLARE country_cursor CURSOR 
    FOR SELECT name FROM country;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET isDone = TRUE;
    OPEN country_cursor;
    myLoop: LOOP
	FETCH country_cursor INTO c_name;
	IF isDone=TRUE THEN LEAVE myLoop;
	END IF;
    IF old.Name = c_name THEN 
		SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Country can't be updated";
        END IF;
	END LOOP;
CLOSE country_cursor;
END//

CREATE TRIGGER if_can_be_deleted
	BEFORE DELETE
    ON country
    FOR EACH ROW 
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
	DECLARE c_name char(45);
    DECLARE country_cursor CURSOR 
    FOR SELECT name FROM country;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET isDone = TRUE;
    OPEN country_cursor;
    myLoop: LOOP
	FETCH country_cursor INTO c_name;
	IF isDone=TRUE THEN LEAVE myLoop;
	END IF;
    IF old.Name = c_name THEN 
		SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Country can't be deleted";
        END IF;
	END LOOP;
CLOSE country_cursor;

END//


    
    







