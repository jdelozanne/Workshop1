/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.util.ArrayList;
import kiteshop.pojos.Klant;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createKlant method, of class KlantDAO.
     */
    @Test
    public void testCreateKlant() {
        System.out.println("createKlant");
        Klant klant = null;
        KlantDAO instance = new KlantDAO();
        instance.createKlant(klant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readKlant method, of class KlantDAO.
     */
    @Test
    public void testReadKlant() {
        System.out.println("readKlant");
        String achternaam = "";
        KlantDAO instance = new KlantDAO();
        Klant expResult = null;
        Klant result = instance.readKlant(achternaam);
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
        System.out.println("readSelectedKlantenAchternaam");
        String a = "";
        KlantDAO instance = new KlantDAO();
        ArrayList<Klant> expResult = null;
        ArrayList<Klant> result = instance.readSelectedKlantenAchternaam(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllKlanten method, of class KlantDAO.
     */
    @Test
    public void testReadAllKlanten() {
        System.out.println("readAllKlanten");
        KlantDAO instance = new KlantDAO();
        instance.readAllKlanten();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayKlanten method, of class KlantDAO.
     */
    @Test
    public void testDisplayKlanten() {
        System.out.println("displayKlanten");
        ArrayList<Klant> klanten = null;
        KlantDAO instance = new KlantDAO();
        instance.displayKlanten(klanten);
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
