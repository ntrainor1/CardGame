-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cardgamedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cardgamedb` ;

-- -----------------------------------------------------
-- Schema cardgamedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cardgamedb` DEFAULT CHARACTER SET utf8 ;
USE `cardgamedb` ;

-- -----------------------------------------------------
-- Table `deck`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deck` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `deck_id` INT NOT NULL,
  `rank` VARCHAR(45) NULL,
  `suit` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `key_card_deck_idx` (`deck_id` ASC),
  CONSTRAINT `key_card_deck`
    FOREIGN KEY (`deck_id`)
    REFERENCES `deck` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NULL,
  `wins` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hand` (
  `player_id` INT NOT NULL,
  `card_id` INT NOT NULL,
  PRIMARY KEY (`player_id`, `card_id`),
  INDEX `key_hand_card_idx` (`card_id` ASC),
  CONSTRAINT `key_hand_player`
    FOREIGN KEY (`player_id`)
    REFERENCES `player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `key_hand_card`
    FOREIGN KEY (`card_id`)
    REFERENCES `card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER 'blackjack'@'localhost' IDENTIFIED BY 'ace';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'blackjack'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `deck`
-- -----------------------------------------------------
START TRANSACTION;
USE `cardgamedb`;
INSERT INTO `deck` (`id`) VALUES (1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `cardgamedb`;
INSERT INTO `player` (`id`, `name`, `wins`) VALUES ('1', 'Dealer', 0);

COMMIT;

-- -----------------------------------------------------
-- Data for table `card`
-- -----------------------------------------------------
START TRANSACTION;
USE `cardgamedb`;
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (5, 1, 'SIX', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (6, 1, 'SEVEN', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (3, 1, 'FOUR', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (11, 1, 'QUEEN', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (7, 1, 'EIGHT', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (2, 1, 'THREE', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (9, 1, 'TEN', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (4, 1, 'FIVE', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (8, 1, 'NINE', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (1, 1, 'TWO', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (10, 1, 'JACK', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (12, 1, 'KING', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (13, 1, 'ACE', 'HEARTS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (14, 1, 'TWO', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (15, 1, 'THREE', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (16, 1, 'FOUR', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (17, 1, 'FIVE', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (18, 1, 'SIX', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (19, 1, 'SEVEN', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (20, 1, 'EIGHT', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (21, 1, 'NINE', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (22, 1, 'TEN', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (23, 1, 'JACK', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (24, 1, 'QUEEN', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (25, 1, 'KING', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (26, 1, 'ACE', 'DIAMONDS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (27, 1, 'TWO', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (28, 1, 'THREE', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (29, 1, 'FOUR', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (30, 1, 'FIVE', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (31, 1, 'SIX', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (32, 1, 'SEVEN', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (33, 1, 'EIGHT', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (34, 1, 'NINE', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (35, 1, 'TEN', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (36, 1, 'JACK', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (37, 1, 'QUEEN', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (38, 1, 'KING', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (39, 1, 'ACE', 'CLUBS');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (40, 1, 'TWO', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (41, 1, 'THREE', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (42, 1, 'FOUR', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (43, 1, 'FIVE', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (44, 1, 'SIX', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (45, 1, 'SEVEN', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (46, 1, 'EIGHT', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (47, 1, 'NINE', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (48, 1, 'TEN', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (49, 1, 'JACK', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (50, 1, 'QUEEN', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (51, 1, 'KING', 'SPADES');
INSERT INTO `card` (`id`, `deck_id`, `rank`, `suit`) VALUES (52, 1, 'ACE', 'SPADES');

COMMIT;
