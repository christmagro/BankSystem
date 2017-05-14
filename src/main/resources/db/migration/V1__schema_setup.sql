#User Account for basic authentication
CREATE TABLE user_account (
  `user_id`       BIGINT       NOT NULL AUTO_INCREMENT,
  `user_username` VARCHAR(45)  NOT NULL,
  `user_password` VARCHAR(200) NOT NULL,
  `user_enable`   BIT(1)       NOT NULL DEFAULT 1,
  UNIQUE INDEX `user_account_id_UNIQUE` (`user_id` ASC),
  PRIMARY KEY (`user_id`)
);

#Address table
CREATE TABLE `address` (
  `address_id`      BIGINT(11)   NOT NULL AUTO_INCREMENT,
  `address_line1`   VARCHAR(200) NOT NULL,
  `address_line2`   VARCHAR(200)          DEFAULT NULL,
  `address_city`    VARCHAR(45)  NOT NULL,
  `address_county`  VARCHAR(45)  NOT NULL,
  `address_primary` BIT(1)       NOT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `address_id_UNIQUE` (`address_id`)
);

#Client Table
CREATE TABLE client (
  `client_id`      BIGINT(11)  NOT NULL AUTO_INCREMENT,
  `client_name`    VARCHAR(45) NOT NULL,
  `client_surname` VARCHAR(45) NOT NULL,
  `client_dob`     DATE        NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `client_id_UNIQUE` (`client_id` ASC)
);

#Linking table that can contain more then one address for the client
CREATE TABLE `client_address` (
  `address_id` BIGINT(11) NOT NULL,
  `client_id`  BIGINT(11) NOT NULL,
  PRIMARY KEY (`address_id`, `client_id`),
  KEY `client_address_client_id_idx` (`client_id`),
  KEY `client_address_address_id_idx` (`address_id`),
  CONSTRAINT `client_address_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `client_address_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

#Accout Table
CREATE TABLE account (
  `account_id`              BIGINT(11)  NOT NULL AUTO_INCREMENT,
  `account_number`          BIGINT(12)  NOT NULL,
  `account_type`            VARCHAR(10) NOT NULL,
  `account_balance`         DOUBLE      NOT NULL DEFAULT '0',
  `account_balance_status`  VARCHAR(2)  NOT NULL,
  `account_timestamp`       DATETIME    NOT NULL,
  `account_overdraft_limit` DOUBLE      NOT NULL DEFAULT '0',
  `client_id`               BIGINT(11)  NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `cleint_id_account_idx` (`client_id`),
  CONSTRAINT `account_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  UNIQUE INDEX `account_id_UNIQUE` (`account_id` ASC),
  UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC)
);

#Transaction Table
CREATE TABLE `transaction` (
  `transaction_id`             BIGINT(11) NOT NULL AUTO_INCREMENT,
  `transaction_debit_account`  BIGINT(11) NOT NULL,
  `transaction_credit_account` BIGINT(11) NOT NULL,
  `transaction_amount`         DOUBLE     NOT NULL,
  `transaction_message`        VARCHAR(45)         DEFAULT NULL,
  `transaction_created`        DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`),
  KEY `Transaction_debit_account_account_id_idx` (`transaction_debit_account`),
  KEY `Transaction_credit_account_id_idx` (`transaction_credit_account`),
  CONSTRAINT `Transaction_credit_account_id` FOREIGN KEY (`transaction_credit_account`) REFERENCES `account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Transaction_debit_account_account_id` FOREIGN KEY (`transaction_debit_account`) REFERENCES `account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/*#Linking table that can contain more then one account for the client
CREATE TABLE `client_account` (
  `client_id`  BIGINT(11) NOT NULL,
  `account_id` BIGINT(11) NOT NULL,
  PRIMARY KEY (`client_id`, `account_id`),
  KEY `client_account_account_id_idx` (`account_id`),
  KEY `client_account_client_id_idx` (`client_id`),
  CONSTRAINT `client_account_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `client_account_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);*/