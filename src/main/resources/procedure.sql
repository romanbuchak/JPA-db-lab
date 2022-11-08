USE `itunes1`;

DROP PROCEDURE IF EXISTS AuthorTestInserts;
DELIMITER //
CREATE PROCEDURE AuthorTestInserts(
    IN new_author_name VARCHAR(50),
    IN new_author_email VARCHAR(50))
BEGIN
    DECLARE max_id INT;
    DECLARE idx INT;
SELECT MAX(id) + 1 INTO max_id FROM `author`;
IF max_id IS NULL THEN
        SET max_id = 1;
END IF;
    SET idx = 1;
    label1:
    WHILE idx < 11
        DO
            INSERT INTO `author` (name, email)
            VALUES (CONCAT(new_author_name, max_id), CONCAT(new_author_email, max_id));
            SET max_id = max_id + 1;
            SET idx = idx + 1;
            ITERATE label1;
END WHILE;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS SongParamInsert;
DELIMITER //
CREATE PROCEDURE SongParamInsert(
    IN new_name VARCHAR(50))
BEGIN
INSERT INTO `song` (name) VALUES (new_name);
SELECT id, name FROM `song` WHERE name = new_name;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CalcAveragePrice;
DELIMITER //
CREATE PROCEDURE CalcAveragePrice()
BEGIN
    DECLARE label VARCHAR(20);
SELECT GetAveragePrice() AS average_price;
END //


# DROP PROCEDURE IF EXISTS CreateSongAuthorRelationship //
# CREATE PROCEDURE CreateSongAuthorRelationship(
#     IN s_name VARCHAR(50),
#     IN auth_name VARCHAR(50))
# BEGIN
#     DECLARE s_id, auth_id INT;
# SELECT id INTO s_id FROM `song` WHERE name = s_name;
# SELECT id INTO auth_id FROM `author` WHERE name = auth_name;
# IF (s_id IS NULL)
#     THEN SIGNAL SQLSTATE '45000'
#         SET MESSAGE_TEXT = 'Null value: no such song found';
# END IF;
#     IF (auth_id IS NULL)
#     THEN SIGNAL SQLSTATE '45000'
#         SET MESSAGE_TEXT = 'Null value: no such author found';
# END IF;
# INSERT INTO `song_author` (song_id, author_id) VALUES (s_id, auth_id);
# END //


DROP PROCEDURE IF EXISTS CreateTablesWithCursor //
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
DELIMITER;
