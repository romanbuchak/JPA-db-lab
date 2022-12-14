CREATE DATABASE IF NOT EXISTS itunes1;
USE itunes1;

DROP TABLE IF EXISTS `user_card`;
DROP TABLE IF EXISTS `service_user`;
DROP TABLE IF EXISTS `download`;
DROP TABLE IF EXISTS `album_of_song`;
DROP TABLE IF EXISTS `author`;
DROP TABLE IF EXISTS `musical_lables`;
DROP TABLE IF EXISTS `song`;
DROP TABLE IF EXISTS `genre`;


CREATE TABLE IF NOT exists `genre`
(
    `id`   int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `type` varchar(35)                    NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT exists `song`
(
    `id`       int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name`     varchar(70)                    NOT NULL,
    `Genre_id` int                            ,
    CONSTRAINT `Song_Genre`
        FOREIGN KEY (`Genre_id`) REFERENCES `genre` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT exists `author`
(
    `id`      int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name`    varchar(50)                    NOT NULL,
    `surname` varchar(50) DEFAULT NULL,
    `gender`  varchar(5)  DEFAULT NULL,
    `email`   varchar(100)                   NOT NULL,
    `Song_id` int                            ,
    CONSTRAINT `Author_Song`
        FOREIGN KEY (`Song_id`) REFERENCES `song` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `album_of_song`
(
    `quantity` int                            NOT NULL,
    `Song_id`  int                            ,
    `id`       int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name`     varchar(70)                    NOT NULL,
    CONSTRAINT `Album_of_song_Song`
        FOREIGN KEY (`Song_id`) REFERENCES `song` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT exists `musical_lables`
(
    `id`       int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name`     varchar(70)                    NOT NULL,
    `is_avard` varchar(5)                     NOT NULL,
    `Song_id`  int                            ,
    CONSTRAINT `Musical_lables_Song`
        FOREIGN KEY (`Song_id`) REFERENCES `song` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT exists `download`
(
    `id`       int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `Song_id`  int                            ,
    `price`    float                          NOT NULL,
    `quantity` int DEFAULT NULL,
    CONSTRAINT `Download_Song`
        FOREIGN KEY (`Song_id`) REFERENCES `song` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT exists `service_user`
(
    `id`              int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name_of_profile` varchar(100)                   NOT NULL,
    `Download_id`     int                            ,
    `user_card_id`    INT                            NOT NULL,
    CONSTRAINT `Service_user_Download`
        FOREIGN KEY (`Download_id`) REFERENCES `download` (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user_card`
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO `genre`
VALUES (1, 'Rock'),
       (2, 'Pop'),
       (3, 'Rep'),
       (4, 'Pop'),
       (5, 'Rock'),
       (6, 'Electronic music'),
       (7, 'Rock'),
       (8, 'Electronic music'),
       (9, 'Rep'),
       (10, 'Pop');

INSERT INTO `song`
VALUES (1, '??????????????', 2),
       (2, '??????????', 4),
       (3, '????????????', 6),
       (4, '???? ?????', 5),
       (5, '???????? ????????', 3),
       (6, '????????????', 1),
       (7, '????????', 7),
       (8, '?????????? ???????????????? ??????????', 10),
       (9, '??????????', 8),
       (10, 'KUPALA', 9);

INSERT INTO `author`
VALUES (1, 'Go_A', NULL, NULL, 'goa@gmail.com', 9),
       (2, '?????????? ?? ????????????', NULL, NULL, 'hungrydogs@gmail.com', 7),
       (3, '???????????? ????????????', NULL, 'W', 'aliona7aliona@gmail.com', 10),
       (4, 'Go_A', NULL, NULL, 'goa@gmail.com', 3),
       (5, 'KAZKA', NULL, NULL, 'kazka317@gmail.com', 1),
       (6, '??????????????', NULL, NULL, 'booooombox@gmail.com', 2),
       (7, 'The Hardkiss', NULL, NULL, 'hardkiss@gmail.com', 4),
       (8, 'Yarmak', NULL, '??', 'yarmakS@gmail.com', 5),
       (9, '??????????????', NULL, 'M', 'skriabin@gmail.com', 8),
       (10, '??????????????????', '??????????????', '??', 'chemerovS4@gmail.com', 6);

INSERT INTO `album_of_song`
VALUES (5, 9, 1, 'Elecm_ua'),
       (5, 4, 2, 'biabooom'),
       (7, 2, 3, 'Family ??i????????'),
       (10, 1, 4, 'bonesry'),
       (11, 10, 5, '??????????'),
       (4, 8, 6, 'stopWar'),
       (5, 6, 7, '????????????'),
       (6, 7, 8, 'happy_life'),
       (7, 3, 9, '??????????'),
       (10, 5, 10, 'ganja');

INSERT INTO `musical_lables`
VALUES (1, 'Secret Service EA', '??????', 5),
       (2, 'Mozgi Group', '??????', 7),
       (3, 'Secret Service EA', '??????', 9),
       (4, 'mamamusic', '??????', 10),
       (5, 'mamamusic', '??????', 1),
       (6, 'Secret Service EA', '??????', 3),
       (7, 'Secret Service EA', '??????', 4),
       (8, 'mamamusic', '??????', 2),
       (9, 'mamamusic', '??????', 6),
       (10, 'Mozgi Group', '??????', 8);

INSERT INTO `download`
VALUES (1, 5, 1.5, 45),
       (2, 1, 1, 100),
       (3, 2, 1, 235),
       (4, 4, 2, 12),
       (5, 10, 3, 444),
       (6, 6, 1.2, 235),
       (7, 8, 2.1, 87),
       (8, 9, 1.7, 94),
       (9, 3, 3.2, 499),
       (10, 7, 0.75, 397);

INSERT INTO `service_user`
VALUES (1, 'Ivan_B', 9, 1),
       (2, 'bib_bob', 6, 3),
       (3, 'nnnnnnnn', 4, 4),
       (4, 'fatily', 2, 3),
       (5, 'myhip', 8, 2),
       (6, 'bone', 10, 2),
       (7, 'cool_girl', 1, 4),
       (8, 'Masha', 3, 1),
       (9, 'Vlad_Vt', 7, 3),
       (10, 'gigant333', 5, 2);

INSERT INTO user_card (name) VALUES ('Visa' );
INSERT INTO user_card (name) VALUES ('MasterCard' );
INSERT INTO user_card (name) VALUES ('?????? card');
INSERT INTO user_card (name) VALUES ('Sence');