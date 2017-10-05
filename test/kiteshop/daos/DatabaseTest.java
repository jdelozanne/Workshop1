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
        String create_product = "CREATE TABLE IF NOT EXISTS `" + DATABASE + "`.`product` (\n"
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
                + "    REFERENCES `" + DATABASE + "`.`bestelling` (`bestellingID`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_bestel_regel_product1`\n"
                + "    FOREIGN KEY (`product_idProduct`)\n"
                + "    REFERENCES `" + DATABASE + "`.`product` (`idProduct`)\n"
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
                + "    REFERENCES `" + DATABASE + "`.`klant` (`KlantID`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)\n"
                + "ENGINE = InnoDB";

        /*
      
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
            stat.executeUpdate(create_product);
            stat.executeUpdate(create_klant);
            stat.executeUpdate(create_bestelregel);
            stat.executeUpdate(create_bestelling);
            /*
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
       
        String insert_account = "INSERT INTO `" + DATABASE + "`.`account` (`gebruikersnaam`, `wachtwoord`) VALUES ('Steef2', 'Bier2');";
        String insert_product = "INSERT INTO `testkiteshop`.`product` (`idProduct`, `productnaam`, `omschrijving`, `prijs`) VALUES ('1', 'Cabrinha Drifter', 'Cabrinha Drifter 2017 Kite Only Red/Blue - 4,5 meter', '719.00'), ('2', 'Cabrinha Chaos', 'Cabrinha Chaos 2017 Kite Only Yellow/Orange - 5,5 meter', '719.00'),('3', 'Brunotti Virtuoso', 'Brunotti Dimension Kiteboard 136 (model 2015)', '399.00');";

        /*
        String insert_klant =
        String insert_bestelling =
        String insert_bestelregel =
        */
        
        /*
        String insert_customer = "INSERT INTO `" + DATABASE + "`.`customer`(`id`,`first_name`,`last_name`,`ln_prefix`,`account_id`) VALUES (1,\"Piet\",\"Pietersen\",null,1), (2,\"Klaas\",\"Klaassen\",null,2),(3,\"Jan\",\"Jansen\",null,3),(4,\"Fred\",\"Boomsma\",null,4),(5,\"Joost\",\"Snel\",null,5)";
        String insert_address = "INSERT INTO `" + DATABASE + "`.`address`(`id`,`street_name`,`number`,`addition`,`postal_code`,`city`,`customer_id`,`address_type_id`) VALUES (1,\"Postweg\",201,\"h\",\"3781JK\",\"Aalst\",1,1),(2,\"Snelweg\",56,null,\"3922JL\",\"Ee\",2,1),(3,\"Torenstraat\",82,null,\"7620CX\",\"Best\",2,2),(4,\"Valkstraat\",9,\"e\",\"2424DF\",\"Goorle\",2,3),(5,\"Dorpsstraat\",5,null,\"9090NM\",\"Best\",3,1),(6,\"Plein\",45,null,\"2522BH\",\"Oss\",4,1),(7,\"Maduralaan\",23,null,\"8967HJ\",\"Apeldoorn\",5,1)";
        String insert_order = "INSERT INTO `" + DATABASE + "`.`order`(`id`,`total_price`,`customer_id`,`date`,`order_status_id`) VALUES (1,230.78,1,\"2016-01-01 01:01:01\",3),(2,62.97,1,\"2016-05-02 01:01:01\",3),(3,144.12,1,\"2017-03-02 01:01:01\",2),(4,78.23,2,\"2017-04-08 01:01:01\",3),(5,6.45,3,\"2017-06-28 01:01:01\",1),(6,324.65,3,\"2017-06-07 01:01:01\",3),(7,46.08,3,\"2017-07-07 01:01:01\",2),(8,99.56,4,\"2017-08-17 01:01:01\",1),(9,23.23,5,\"2017-09-13 01:01:01\",3)";
         = "INSERT INTO `" + DATABASE + "`.`product`(`id`,`name`,`price`,`stock`) VALUES (1,\"Goudse belegen kaas\",12.90,134),(2,\"Goudse extra belegen kaas\",14.70,239),(3,\"Leidse oude kaas\",14.65,89),(4,\"Schimmelkaas\",11.74,256),(5,\"Leidse jonge kaas\",11.24,122),(6,\"Boeren jonge kaas\",12.57,85)";
        String insert_order_item = "INSERT INTO `" + DATABASE + "`.`order_item`(`id`,`order_id`,`product_id`,`amount`,`subtotal`) VALUES (1,1,6,23,254.12),(2,1,1,26,345.20),(3,1,2,2,24.14),(4,2,1,25,289.89),(5,3,4,2,34.89),(6,4,2,13,156.76),(7,4,5,2,23.78),(8,5,2,2,21.34),(9,6,1,3,35.31),(10,6,3,1,11.23),(11,7,6,1,14.23),(12,7,2,3,31.87),(13,8,4,23,167.32),(14,9,1,1,11.34),(15,9,2,2,22.41)";
        logger.info("Try connection for pop database");
        */
        try {

            // Execute the SQL statements to insert the test data into the DATABASE
            Statement stat = connection.createStatement();
            
            stat.executeUpdate(insert_account);
            stat.executeUpdate(insert_product);
            /*
            stat.executeUpdate(insert_customer);
            stat.executeUpdate(insert_address);
            stat.executeUpdate(insert_order);
            stat.executeUpdate(insert_product);
            stat.executeUpdate(insert_order_item);
            */

        } catch (SQLException ex) {
            logger.info("SQLException" + ex);
        }
    }

}
