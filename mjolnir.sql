-- -----------------------------------------------------
-- schema mjolnir
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mjolnir`;

CREATE SCHEMA `mjolnir`;
USE `mjolnir`;

-- -----------------------------------------------------
-- table movie
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mjolnir`.`movie` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `imdb_rating` DECIMAL(2 , 1 ) NOT NULL,
    `year_of_release` YEAR NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`)
)  ENGINE=INNODB AUTO_INCREMENT=1;

select * from movie;