CREATE TABLE IF NOT EXISTS `book_sale`.`register`
(
    `account` VARCHAR
(
    20
) NOT NULL,
    `pwd` VARCHAR
(
    45
) NOT NULL,`reg_time` DATETIME NULL ,`active` TINYINT NOT NULL, PRIMARY KEY
(
    `account`
)
    );