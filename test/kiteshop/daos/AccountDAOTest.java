/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import kiteshop.pojos.Account;
<<<<<<< Updated upstream
import org.junit.AfterClass;
=======
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
>>>>>>> Stashed changes
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
<<<<<<< Updated upstream
 * @author Steef P
=======
 * @author julia
>>>>>>> Stashed changes
 */
public class AccountDAOTest {
    
    public AccountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
<<<<<<< Updated upstream
=======
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
>>>>>>> Stashed changes

    /**
     * Test of postNieuwAccount method, of class AccountDAO.
     */
    @Test
<<<<<<< Updated upstream
    // Ik maak hier gebruik van de contriolleer inlog  functie om de PostNieuw Account te testen, weet niet zeker of dit de bedoeling is, maar lijkt me opzich wel de beste optie
    public void testPostNieuwAccount() {
        System.out.println("postNieuwAccount");
        Account account = new Account();
        account.setGebruikersnaam("User1");
        account.setWachtwoord("WW1");
        AccountDAO instance = new AccountDAO();
        instance.postNieuwAccount(account);
        
        String expResult = "WW1";
        String result = new AccountDAO().givePassword("User1");
        
            assertEquals(expResult, result);
    }

    /**
     * Test of controleerInlog method, of class AccountDAO.
     */
    
    // Deze werkt!!!  Dit is ook de enige die makkelijk apart te testen is volgens mij
    @Test
    public void testControleerInlog() {
        System.out.println("controleerInlog");
        String gebruiker = "Steef";
        AccountDAO instance = new AccountDAO();
        String expResult = "Bier";
        String result = instance.givePassword(gebruiker);
        assertEquals(expResult, result);
       
    }  
=======
    public void testPostNieuwAccount() {
        System.out.println("postNieuwAccount");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        instance.postNieuwAccount(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of givePassword method, of class AccountDAO.
     */
    @Test
    public void testGivePassword() {
        System.out.println("givePassword");
        String gebruiker = "julia";
        AccountDAO instance = new AccountDAO();
        String expResult = "geheim";
        String result = instance.givePassword(gebruiker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class AccountDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccountDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
>>>>>>> Stashed changes
}
