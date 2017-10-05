/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import kiteshop.test.ProjectLog;

/**
 *
 * @author Steef P
 */
public class DatabaseTest {

    private static final Logger logger = ProjectLog.getLogger();

    Connection connection;

    public DatabaseTest() {
        this.connection = DBConnect.getConnection();
    }

    private static final String DATABASE = "TestKiteshop";

    void initializeDatabase() {
        logger.info("Entering initializeDatabase()");
        // Prepare the SQL statements to drop the DATABASE and recreate it

        String opening1 = "SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0";
        String opening2 = "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0; ";
        String opening3 = "SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES'";

        String dropDatabase = "DROP DATABASE IF EXISTS " + DATABASE;
        String createDatabase = "CREATE DATABASE IF NOT EXISTS " + DATABASE;
        String create_account = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`account`  (\n"
                + "  `accountID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  `gebruikersnaam` VARCHAR(45) NOT NULL,\n"
                + "  `wachtwoord` VARCHAR(45) NOT NULL,\n"
                + "  `Accountcol` VARCHAR(45) NULL DEFAULT NULL,\n"
                + "  PRIMARY KEY (`accountID`))\n"
                + "ENGINE = InnoDB";  // de engine kun je ook weghalen dan werkt het ook SP
        String product = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`product` (\n"
                + "  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `productnaam` VARCHAR(45) NOT NULL,\n"
                + "  `omschrijving` VARCHAR(60) NOT NULL,\n"
                + "  `prijs` DECIMAL(10,2) UNSIGNED NOT NULL,\n"
                + "  PRIMARY KEY (`idProduct`),\n"
                + "  UNIQUE INDEX `idProduct_UNIQUE` (`idProduct` ASC))\n"
                + "ENGINE = InnoDB";
        String create_klant = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`klant`(\n"
                + "  `KlantID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  `voornaam` VARCHAR(45) NOT NULL,\n"
                + "  `tussenvoegsel` VARCHAR(45) NULL DEFAULT NULL,\n"
                + "  `achternaam` VARCHAR(45) NOT NULL,\n"
                + "  `emailadres` VARCHAR(45) NULL DEFAULT NULL,\n"
                + "  `straatnaam` VARCHAR(45) NOT NULL,\n"
                + "  `huisnummer` INT(11) NOT NULL,\n"
                + "  `toevoeging` VARCHAR(45) NULL DEFAULT NULL,\n"
                + "  `postcode` VARCHAR(45) NOT NULL,\n"
                + "  `plaats` VARCHAR(45) NOT NULL,\n"
                + "  `telefoonnummer` VARCHAR(20) NOT NULL,\n"
                + "  PRIMARY KEY (`KlantID`),\n"
                + "  UNIQUE INDEX `telefoonnummer_UNIQUE` (`telefoonnummer` ASC))\n"
                + "ENGINE = InnoDB";
        String create_bestelregel = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`bestel_regel` (\n"
                + "  `bestel_regelID` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `aantal` INT(11) NOT NULL,\n"
                + "  `Bestelling_bestellingID` INT(10) UNSIGNED NOT NULL,\n"
                + "  `product_idProduct` INT(11) NOT NULL,\n"
                + "  PRIMARY KEY (`bestel_regelID`),\n"
                + "  UNIQUE INDEX `bestel_regelID_UNIQUE` (`bestel_regelID` ASC),\n"
                + "  INDEX `fk_Bestel_regel_Bestelling1_idx` (`Bestelling_bestellingID` ASC),\n"
                + "  INDEX `fk_bestel_regel_product1_idx` (`product_idProduct` ASC),\n"
                + "  CONSTRAINT `fk_Bestel_regel_Bestelling1`\n"
                + "    FOREIGN KEY (`Bestelling_bestellingID`)\n"
                + "    REFERENCES `juliaworkshop`.`bestelling` (`bestellingID`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_bestel_regel_product1`\n"
                + "    FOREIGN KEY (`product_idProduct`)\n"
                + "    REFERENCES `juliaworkshop`.`product` (`idProduct`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)\n"
                + "ENGINE = InnoDB";
        String create_bestelling = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`bestelling` (\n"
                + "  `bestellingID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                + "  `klantID` INT(10) UNSIGNED NOT NULL,\n"
                + "  `bestel_regelID` INT(11) NOT NULL,\n"
                + "  `totaalprijs` DECIMAL(10,2) NOT NULL,\n"
                + "  PRIMARY KEY (`bestellingID`),\n"
                + "  INDEX `klantID_idx` (`klantID` ASC),\n"
                + "  CONSTRAINT `klantID`\n"
                + "    FOREIGN KEY (`klantID`)\n"
                + "    REFERENCES `juliaworkshop`.`klant` (`KlantID`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)\n"
                + "ENGINE = InnoDB";

        /*
        String create_account = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`account` (`id` INT NOT NULL AUTO_INCREMENT, `username` VARCHAR(25) NOT NULL, `password` VARCHAR(180) NOT NULL, `account_type_id` INT NOT NULL, PRIMARY KEY (`id`), INDEX `fk_account_account_type1_idx` (`account_type_id` ASC), UNIQUE INDEX `username_UNIQUE` (`username` ASC), CONSTRAINT `fk_account_account_type1` FOREIGN KEY (`account_type_id`) REFERENCES `"+DATABASE+"`.`account_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB";
        String create_customer = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`customer` (`id` INT NOT NULL AUTO_INCREMENT, `first_name` VARCHAR(50) NOT NULL, `last_name` VARCHAR(50) NOT NULL, `ln_prefix` VARCHAR(15) NULL, `account_id` INT NULL, PRIMARY KEY (`id`), INDEX `fk_klant_account1_idx` (`account_id` ASC), CONSTRAINT `fk_klant_account1` FOREIGN KEY (`account_id`) REFERENCES `"+DATABASE+"`.`account` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION) ENGINE = InnoDB";
        String address_type = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`address_type` (`id` INT NOT NULL AUTO_INCREMENT, `type` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB";
        String address = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`address` (`id` INT NOT NULL AUTO_INCREMENT, `street_name` VARCHAR(50) NOT NULL, `number` INT NOT NULL, `addition` VARCHAR(5) NULL, `postal_code` VARCHAR(6) NOT NULL, `city` VARCHAR(45) NOT NULL, `customer_id` INT NOT NULL, `address_type_id` INT NOT NULL, PRIMARY KEY (`id`), INDEX `fk_adres_klant_idx` (`customer_id` ASC), INDEX `fk_adres_adres_type1_idx` (`address_type_id` ASC), CONSTRAINT `fk_adres_klant` FOREIGN KEY (`customer_id`) REFERENCES `"+DATABASE+"`.`customer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION, CONSTRAINT `fk_adres_adres_type1` FOREIGN KEY (`address_type_id`) REFERENCES `"+DATABASE+"`.`address_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB";
        String order_status = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`order_status` (`id` INT NOT NULL AUTO_INCREMENT, `status` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB";
        String order = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`order` (`id` INT NOT NULL AUTO_INCREMENT, `total_price` DECIMAL(6,2) NOT NULL, `customer_id` INT NOT NULL, `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `order_status_id` INT NOT NULL, PRIMARY KEY (`id`), INDEX `fk_bestelling_klant1_idx` (`customer_id` ASC),  INDEX `fk_bestelling_bestelling_status1_idx` (`order_status_id` ASC), CONSTRAINT `fk_bestelling_klant1` FOREIGN KEY (`customer_id`) REFERENCES `"+DATABASE+"`.`customer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION, CONSTRAINT `fk_bestelling_bestelling_status1` FOREIGN KEY (`order_status_id`) REFERENCES `"+DATABASE+"`.`order_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB";
        String product = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`product` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, `price` DECIMAL(6,2) NOT NULL, `stock` INT NOT NULL, PRIMARY KEY (`id`), UNIQUE INDEX `name_UNIQUE` (`name` ASC)) ENGINE = InnoDB";
        String order_item = "CREATE TABLE IF NOT EXISTS `"+DATABASE+"`.`order_item` (`id` INT NOT NULL AUTO_INCREMENT, `order_id` INT NOT NULL, `product_id` INT NULL, `amount` INT NOT NULL, `subtotal` DECIMAL(6,2) NOT NULL, INDEX `fk_bestel_regel_bestelling1_idx` (`order_id` ASC), INDEX `fk_bestel_regel_artikel1_idx` (`product_id` ASC), PRIMARY KEY (`id`), CONSTRAINT `fk_bestel_regel_bestelling1` FOREIGN KEY (`order_id`) REFERENCES `"+DATABASE+"`.`order` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION, CONSTRAINT `fk_bestel_regel_artikel1` FOREIGN KEY (`product_id`) REFERENCES `"+DATABASE+"`.`product` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION) ENGINE = InnoDB";
        
        //in neem aan dat dit is om opnieuw met 1 te begginnen met tellen
        String trigger = "CREATE DEFINER = CURRENT_USER TRIGGER `"+DATABASE+"`.`customer_BEFORE_DELETE` BEFORE DELETE ON `customer` FOR EACH ROW DELETE FROM account WHERE id = OLD.account_id;";
         */
        try {

            Statement stat = connection.createStatement();
            
            stat.executeUpdate(opening1);
            stat.executeUpdate(opening2);
            stat.executeUpdate(opening3);
            stat.executeUpdate(dropDatabase);
            stat.executeUpdate(createDatabase); // Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement or an SQL statement that returns nothing, such as an SQL DDL statement. ExecuteQuery kan niet gebruikt worden voor DDL statements
            stat.executeUpdate(create_account);
            stat.executeUpdate(product);
            stat.executeUpdate(create_klant);
            stat.executeUpdate(create_bestelregel);
            stat.executeUpdate(create_bestelling);
            /*
            stat.executeUpdate(create_account);
           
            stat.executeUpdate(address_type);
            stat.executeUpdate(address);            
            stat.executeUpdate(order_status);
            stat.executeUpdate(order);
            
            stat.executeUpdate(order_item);            
            stat.executeUpdate(trigger);
             */

        } catch (SQLException ex) {
            logger.info("SQLException" + ex);
        }
    }

    void populateDatabase() {
        logger.info("Entering populate database");
        // Generate the required password hashes
        String pass1 = "welkom";
        String pass2 = "welkom";
        String pass3 = "welkom";
        String pass4 = "geheim";
        String pass5 = "welkom";
        String pass6 = "welkom";
        // Prepare the SQL statements to insert the test data into the DATABASE
        String insert_account_type = "INSERT INTO `" + DATABASE + "`.`account_type`(`id`,`type`) VALUES (1,\"admin\"),(2,\"medewerker\"),(3,\"klant\")";
        String insert_address_type = "INSERT INTO `" + DATABASE + "`.`address_type`(`id`,`type`) VALUES (1,\"postadres\"),(2,\"factuuradres\"),(3,\"bezorgadres\")";
        String insert_order_status = "INSERT INTO `" + DATABASE + "`.`order_status`(`id`,`status`) VALUES (1,\"nieuw\"),(2,\"in behandeling\"),(3,\"afgehandeld\")";
        String insert_account = "INSERT INTO `" + DATABASE + "`.`account`(`id`,`username`,`password`,`account_type_id`) VALUES (1,\"piet\",\"" + pass1 + "\",1),(2,\"klaas\",\"" + pass2 + "\",2),(3,\"jan\",\"" + pass3 + "\",3),(4,\"fred\",\"" + pass4 + "\",3),(5,\"joost\",\"" + pass5 + "\",3),(6,\"jaap\",\"" + pass6 + "\",3)";
        String insert_customer = "INSERT INTO `" + DATABASE + "`.`customer`(`id`,`first_name`,`last_name`,`ln_prefix`,`account_id`) VALUES (1,\"Piet\",\"Pietersen\",null,1), (2,\"Klaas\",\"Klaassen\",null,2),(3,\"Jan\",\"Jansen\",null,3),(4,\"Fred\",\"Boomsma\",null,4),(5,\"Joost\",\"Snel\",null,5)";
        String insert_address = "INSERT INTO `" + DATABASE + "`.`address`(`id`,`street_name`,`number`,`addition`,`postal_code`,`city`,`customer_id`,`address_type_id`) VALUES (1,\"Postweg\",201,\"h\",\"3781JK\",\"Aalst\",1,1),(2,\"Snelweg\",56,null,\"3922JL\",\"Ee\",2,1),(3,\"Torenstraat\",82,null,\"7620CX\",\"Best\",2,2),(4,\"Valkstraat\",9,\"e\",\"2424DF\",\"Goorle\",2,3),(5,\"Dorpsstraat\",5,null,\"9090NM\",\"Best\",3,1),(6,\"Plein\",45,null,\"2522BH\",\"Oss\",4,1),(7,\"Maduralaan\",23,null,\"8967HJ\",\"Apeldoorn\",5,1)";
        String insert_order = "INSERT INTO `" + DATABASE + "`.`order`(`id`,`total_price`,`customer_id`,`date`,`order_status_id`) VALUES (1,230.78,1,\"2016-01-01 01:01:01\",3),(2,62.97,1,\"2016-05-02 01:01:01\",3),(3,144.12,1,\"2017-03-02 01:01:01\",2),(4,78.23,2,\"2017-04-08 01:01:01\",3),(5,6.45,3,\"2017-06-28 01:01:01\",1),(6,324.65,3,\"2017-06-07 01:01:01\",3),(7,46.08,3,\"2017-07-07 01:01:01\",2),(8,99.56,4,\"2017-08-17 01:01:01\",1),(9,23.23,5,\"2017-09-13 01:01:01\",3)";
        String insert_product = "INSERT INTO `" + DATABASE + "`.`product`(`id`,`name`,`price`,`stock`) VALUES (1,\"Goudse belegen kaas\",12.90,134),(2,\"Goudse extra belegen kaas\",14.70,239),(3,\"Leidse oude kaas\",14.65,89),(4,\"Schimmelkaas\",11.74,256),(5,\"Leidse jonge kaas\",11.24,122),(6,\"Boeren jonge kaas\",12.57,85)";
        String insert_order_item = "INSERT INTO `" + DATABASE + "`.`order_item`(`id`,`order_id`,`product_id`,`amount`,`subtotal`) VALUES (1,1,6,23,254.12),(2,1,1,26,345.20),(3,1,2,2,24.14),(4,2,1,25,289.89),(5,3,4,2,34.89),(6,4,2,13,156.76),(7,4,5,2,23.78),(8,5,2,2,21.34),(9,6,1,3,35.31),(10,6,3,1,11.23),(11,7,6,1,14.23),(12,7,2,3,31.87),(13,8,4,23,167.32),(14,9,1,1,11.34),(15,9,2,2,22.41)";
        logger.info("Try connection for pop database");
        try {

            // Execute the SQL statements to insert the test data into the DATABASE
            Statement stat = connection.createStatement();
            stat.executeUpdate(insert_account_type);
            stat.executeUpdate(insert_address_type);
            stat.executeUpdate(insert_order_status);
            stat.executeUpdate(insert_account);
            stat.executeUpdate(insert_customer);
            stat.executeUpdate(insert_address);
            stat.executeUpdate(insert_order);
            stat.executeUpdate(insert_product);
            stat.executeUpdate(insert_order_item);

        } catch (SQLException ex) {
            logger.info("SQLException" + ex);
        }
    }

}
