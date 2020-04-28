/* 
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */


/* User Table Code */
CREATE TABLE `dashboard_db`.`users`
 ( `id` INT NOT NULL AUTO_INCREMENT , 
 `email` VARCHAR(255) NOT NULL , 
 `password` VARCHAR(255) NOT NULL , 
 `userType` VARCHAR(20) NOT NULL DEFAULT 'user' , 
 PRIMARY KEY (`id`), UNIQUE (`email`)
 ) ENGINE = MyISAM;


/* Example Graph Table */
CREATE TABLE `dashboard_db`.`fruitdata` ( `id` INT NOT NULL AUTO_INCREMENT , `fruitName` VARCHAR(50) NOT NULL , `amount` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

/* Insert Example Graph Data */
INSERT INTO `fruitdata` (`id`, `fruitName`, `amount`) VALUES 
(NULL, 'Peach', '35'), 
(NULL, 'Orange', '87'),
(NULL, 'Lemon', '3'),
(NULL, 'Apple', '84'),
(NULL, 'Banana', '11'),
(NULL, 'Grapes', '5'),
(NULL, 'Strawberry', '66')