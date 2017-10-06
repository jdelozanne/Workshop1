/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import kiteshop.pojos.Adres;
import kiteshop.pojos.Klant;
import kiteshop.test.ProjectLog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steef P
 */
public class KlantDAOTest {
	
	private final Logger logger = ProjectLog.getLogger();
    
    public KlantDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	// Na het opzetten van de testdatabase moeten de daos verbinding gaan maken met deze test database, dus wordt het pad in DBConnect veranderd naar het pad van de test database
    	
    	//De database wordt opgezet voor iedere test, helemaal leeg, evt kan per test middels "new DatabaseTest().populateDatabase();" van waarden worden voorzien
    	new DatabaseTest().initializeDatabase();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createKlant method, of class KlantDAO.
     */
    @Test
    public void testCreateKlant() {
    	logger.info("Entering createAddKlant");
        
    	//Het maken van de testKlant om aan de testdatabase toe te voegen
        Klant testKlant = new Klant();
        testKlant.setVoornaam("Steef");
        testKlant.setTussenvoegsel("v");
        testKlant.setAchternaam("Pelgrom");
        Adres adres = new Adres();
        adres.setWoonplaats("Tilburg");
        adres.setStraatnaam("Hendrik van Tulderstraat");
        adres.setPostcode("5046NC");
        adres.setHuisnummer(17);
        adres.setToevoeging("a");
        adres.setEmail("s.pelgrom@hotmail.com");
        adres.setTelefoon(06-26634587);
        testKlant.setAdres(adres);
        
        //het toevoegen van de klant via de te testen klantDAO
        KlantDAO instance = new KlantDAO();
        instance.createKlant(testKlant);
        
        //Het uit de database halen van de waarden van de klant en hier weer een nieuwe resultaat kalnt van maken
        Klant resultKlant = new Klant();
        Connection connection = DBConnect.getConnection();
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from klant");

        	ResultSet rSet = statement.executeQuery();

            while (rSet.next()) {
                int KlantID = rSet.getInt(1);
                String voornaam = rSet.getString(2);
                String tussenvoegsel = rSet.getString(3);
                String achternaam = rSet.getString(4);
                String emailadres = rSet.getString(5);
                String straatnaam = rSet.getString(6);
                int huismummer = rSet.getInt(7);
                String toevoeging = rSet.getString(8);
                String postcode = rSet.getString(9);
                String woonplaats = rSet.getString(10);

                Adres resultAdres = new Adres();
                resultAdres.setStraatnaam(straatnaam);
                resultAdres.setHuisnummer(huismummer);
                resultAdres.setToevoeging(toevoeging);
                resultAdres.setPostcode(postcode);
                resultAdres.setWoonplaats(woonplaats);
                
                resultKlant.setVoornaam(voornaam);
                resultKlant.setTussenvoegsel(tussenvoegsel);
                resultKlant.setAchternaam(achternaam);
                adres.setEmail(emailadres);
                resultKlant.setAdres(adres);

                System.out.println("Resultklant: "+voornaam + tussenvoegsel + achternaam + emailadres + straatnaam + huismummer + toevoeging + postcode + woonplaats);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
         
        Klant expResult = testKlant;
        Klant result = resultKlant;
        
        System.out.println("Expected Result: " +expResult);
        System.out.println("Reasult" +result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of readKlant method, of class KlantDAO.
     */
    @Test
    public void testReadKlant() {
        System.out.println("readKlant");
      
        KlantDAO instance = new KlantDAO();
        Klant expResult = null;
        Klant result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateKlant method, of class KlantDAO.
     */
    @Test
    public void testUpdateKlant() {
        System.out.println("updateKlant");
        Klant klant = null;
        KlantDAO instance = new KlantDAO();
        instance.updateKlant(klant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteKlant method, of class KlantDAO.
     */
    @Test
    public void testDeleteKlant() {
        System.out.println("deleteKlant");
        Klant klant = null;
        KlantDAO instance = new KlantDAO();
        instance.deleteKlant(klant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readSelectedKlantenAchternaam method, of class KlantDAO.
     */
    @Test
    public void testReadSelectedKlantenAchternaam() {
    	new DatabaseTest().populateDatabase();
    	//Hieronder wordt een klant gemaakt, met de populateDatabase is precies zo'n klant gemaakt.
    	Klant verwachtResultKlant = new Klant();
    	verwachtResultKlant.setVoornaam("Steef");
      	verwachtResultKlant.setAchternaam("Pelgrom");
        Adres adres = new Adres();
        adres.setWoonplaats("Tilburg");
        adres.setStraatnaam("Hendriklaan");
        adres.setPostcode("5034KL");
        adres.setHuisnummer(38);
        adres.setEmail("stevey@hotmail.com");
        adres.setTelefoon(06-56847965);
        verwachtResultKlant.setAdres(adres);
              

    	KlantDAO instance = new KlantDAO();
        
        Klant expResult = verwachtResultKlant;
        //Aangezien de functie een Arraylist terug geeft, maar ik Equals niet kan overschrijven in Arraylist
        //vergelijk ik de verwachtte klant met de eerste klant uit de Array van de uitkomst de Methode test
        Klant result = instance.readSelectedKlantenAchternaam("Pelgrom").get(0);
        System.out.println(expResult);
        System.out.println(result);
        
       
        
        assertEquals(expResult, result);
        
    }

    
}
