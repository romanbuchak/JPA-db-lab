USE `itunes1`;

DROP PROCEDURE IF EXISTS SongParamInsert;
DELIMITER //
CREATE PROCEDURE SongParamInsert(
    IN new_name VARCHAR(50))
BEGIN
INSERT INTO `song` (name) VALUES (new_name);
SELECT id, name, Genre_id FROM `song` WHERE name = new_name;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CalcAveragePrice;
DELIMITER //
CREATE PROCEDURE CalcAveragePrice()
BEGIN
    DECLARE label VARCHAR(20);
SELECT GetAveragePrice() AS average_price;
END //

DROP PROCEDURE IF EXISTS CreateTablesWithCursor;
DELIMITER //
CREATE PROCEDURE CreateTablesWithCursor()
BEGIN
    DECLARE done BOOL DEFAULT false;
    DECLARE genre_type VARCHAR(50);
    DECLARE my_cursor CURSOR
        FOR SELECT type FROM `genre`;

    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = true;

    OPEN my_cursor;
    my_loop: LOOP
        FETCH my_cursor INTO genre_type;
        IF (done = true) THEN LEAVE my_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE TABLE IF NOT EXISTS ', genre_type, DATE_FORMAT(NOW(), '_%Y_%m_%d_%H_%i_%s'), ' (', genre_type, '1 INT, ', genre_type, '2 BOOL);');
        PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
    END LOOP;
    CLOSE my_cursor;
END //


DELIMITER ;
