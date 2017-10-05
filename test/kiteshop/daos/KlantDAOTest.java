/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.util.ArrayList;
import kiteshop.pojos.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steef P
 */
public class KlantDAOTest {
    
    public KlantDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createKlant method, of class KlantDAO.
     */
    @Test
    public void testAddKlant() {
        System.out.println("addKlant");
        
               
        
        Klant klant = new Klant();
        klant.setVoornaam("Steef");
        klant.setTussenvoegsel("v");
        klant.setAchternaam("Pelgrom");
        Adres adres = new Adres();
        adres.setWoonplaats("Tilburg");
        adres.setStraatnaam("Hendrik van Tulderstraat");
        adres.setPostcode("5046NC");
        adres.setHuisnummer(17);
        adres.setToevoeging("a");
        adres.setEmail("s.pelgrom@hotmail.com");
        adres.setTelefoon(06-26634587);
        
        
        
        klant.setAdres(adres);
        
        KlantDAO instance = new KlantDAO();
        instance.createKlant(klant);
        
        String expResult = klant.toString();
        String result = instance.readSelectedKlantenAchternaam("Pelgrom").get(0).toString();
        
        System.out.println("Expected Result: " +expResult);
        System.out.println("Reasult" +result);
        
        assertEquals(expResult, result);
        
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
     * Nog niet klaar!!
     */
    @Test
    public void testShowKlantenAchternaam() {
        System.out.println("showKlantenAchternaam");
        
        String achterNaam = "Pelegrino";
        Klant klant = new Klant();
        klant.setVoornaam("Stevey");
        klant.setTussenvoegsel("v");
        klant.setAchternaam(achterNaam);
        Adres adres = new Adres();
        adres.setWoonplaats("Tilburg");
        adres.setStraatnaam("Hendrik van Tulderstraat");
        adres.setPostcode("5046NC");
        adres.setHuisnummer(17);
        adres.setToevoeging("a");
        adres.setEmail("s.pelgrom@hotmail.com");
        adres.setTelefoon(06-26634587);
        
        klant.setAdres(adres);
        
        
        
        
        ArrayList<Klant> klantenlijst = new ArrayList<Klant>();
        klantenlijst.add(klant);
        
        
        KlantDAO instance = new KlantDAO();
        instance.createKlant(klant);
        ArrayList<Klant> expResult = klantenlijst;
        ArrayList<Klant> result = instance.readSelectedKlantenAchternaam(achterNaam);
        System.out.println(expResult);
        System.out.println(result);
        
       
        
        assertEquals(expResult.toString(), result.toString());
        
    }

    /**
     * Test of main method, of class KlantDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        KlantDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
