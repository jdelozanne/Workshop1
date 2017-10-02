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
     * Test of addKlant method, of class KlantDAO.
     */
    @Test
    public void testAddKlant() {
        System.out.println("addKlant");
        Klant klant = null;
        KlantDAO instance = new KlantDAO();
        instance.addKlant(klant);
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
     * Test of showKlantenAchternaam method, of class KlantDAO.
     */
    @Test
    public void testShowKlantenAchternaam() {
        System.out.println("showKlantenAchternaam");
        String achterNaam = "Pelgrom";
        ArrayList<Klant> klantenlijst = new ArrayList<Klant>();
        Klant klant = new Klant();
        klant.setVoornaam("Steef");
        klant.setTussenvoegsel("v");
        klant.setAchternaam("Pelgrom");
        klant.setTelefoonnummer("06-26634587");
        klant.setEmail("s.pelgrom@hotmail.com");
        Adres adres = new Adres();
        adres.setStraatnaam("Hendrik van Tulderstraat");
        adres.setPostcode("5046NC");
        adres.setHuisnummer(17);
        adres.setToevoeging("a");
        klant.setAdres(adres);
        klant.setAchternaam(achterNaam);
        klantenlijst.add(klant);
        KlantDAO instance = new KlantDAO();
        ArrayList<Klant> expResult = klantenlijst;
        ArrayList<Klant> result = instance.showKlantenAchternaam(achterNaam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
