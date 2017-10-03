/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import kiteshop.pojos.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julia
 */
public class MenuAccountsTest {
    
    public MenuAccountsTest() {
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
     * Test of start method, of class MenuAccounts.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        MenuAccounts instance = new MenuAccounts();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maakNieuwAccount method, of class MenuAccounts.
     */
    @Test
    public void testMaakNieuwAccount() {
        System.out.println("maakNieuwAccount");
        MenuAccounts instance = new MenuAccounts();
        instance.maakNieuwAccount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maakNieuwWachtwoord method, of class MenuAccounts.
     */
    @Test
    public void testMaakNieuwWachtwoord() {
        System.out.println("maakNieuwWachtwoord");
        Account account = null;
        MenuAccounts instance = new MenuAccounts();
        instance.maakNieuwWachtwoord(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAccount method, of class MenuAccounts.
     */
    @Test
    public void testPrintAccount() {
        System.out.println("printAccount");
        MenuAccounts instance = new MenuAccounts();
        instance.printAccount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wijzigAccount method, of class MenuAccounts.
     */
    @Test
    public void testWijzigAccount() {
        System.out.println("wijzigAccount");
        MenuAccounts.wijzigAccount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verwijderAccount method, of class MenuAccounts.
     */
    @Test
    public void testVerwijderAccount() {
        System.out.println("verwijderAccount");
        MenuAccounts.verwijderAccount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
