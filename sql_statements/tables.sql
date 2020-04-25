/* 
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */

CREATE TABLE `dashboard_db`.`users`
 ( `id` INT NOT NULL AUTO_INCREMENT , 
 `email` VARCHAR(255) NOT NULL , 
 `password` VARCHAR(255) NOT NULL , 
 `userType` VARCHAR(20) NOT NULL DEFAULT 'user' , 
 PRIMARY KEY (`id`), UNIQUE (`email`)
 ) ENGINE = MyISAM;
