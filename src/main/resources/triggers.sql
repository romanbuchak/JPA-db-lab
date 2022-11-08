USE `itunes1`;

DELIMITER //
DROP TRIGGER IF EXISTS CreateDownloadCheckUserCard //
CREATE TRIGGER CreateDownloadCheckUserCard
    BEFORE INSERT
    ON `itunes1`.`service_user` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `itunes1`.`user_card`
            WHERE id = NEW.user_card_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: No user_card with such id';
END IF;
END //

DROP TRIGGER IF EXISTS UpdateDownloadCheckUserCard //
CREATE TRIGGER UpdateDownloadCheckUserCard
    BEFORE UPDATE
    ON `itunes1`.`service_user` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `itunes1`.`user_card`
            WHERE id = NEW.user_card_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: No user_card with with such id';
END IF;
END //

DROP TRIGGER IF EXISTS UpdateUserCardCheckId //
CREATE TRIGGER UpdateUserCardCheckId
    BEFORE UPDATE
    ON `itunes1`.`user_card` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT user_card_id FROM `itunes1`.`service_user`
            WHERE user_card_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: Can`t update row with record present in related table';
END IF;
END //


DROP TRIGGER IF EXISTS DeleteUserCardCheckId //
CREATE TRIGGER DeleteUserCardCheckId
    BEFORE DELETE
    ON `itunes1`.`user_card` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT  user_card_id FROM `itunes1`.`service_user`
            WHERE user_card_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: Can`t delete row with record present in related table';
END IF;
END //

DROP TRIGGER IF EXISTS CheckQuantity//
CREATE TRIGGER CheckQuantity
    BEFORE INSERT
    ON `itunes1`.`download` FOR EACH ROW
BEGIN
    IF (NEW.quantity < 0)
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Value error: quantity can`t be less than 0';
END IF;
END //

DROP TRIGGER IF EXISTS CheckAuthorName //
CREATE TRIGGER CheckAuthorName
    BEFORE INSERT
    ON `itunes1`.`author` FOR EACH ROW
BEGIN
    IF (NEW.name NOT RLIKE '^[a-zA-Z0-9]')
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Value error: invalid name format';
END IF;
END //

DROP TRIGGER IF EXISTS ForbidDeleteSong //
CREATE TRIGGER ForbidDeleteSong
    BEFORE DELETE
    ON `itunes1`.`song` FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Forbidden method: you can`t delete data from table `song`';
END //

DELIMITER ;