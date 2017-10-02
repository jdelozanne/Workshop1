/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import kiteshop.pojos.Account;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steef P
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

    /**
     * Test of postNieuwAccount method, of class AccountDAO.
     */
    @Test
    // Ik maak hier gebruik van de contriolleer inlog  functie om de PostNieuw Account te testen, weet niet zeker of dit de bedoeling is, maar lijkt me opzich wel de beste optie
    public void testPostNieuwAccount() {
        System.out.println("postNieuwAccount");
        Account account = new Account();
        account.setGebruikersnaam("User1");
        account.setWachtwoord("WW1");
        AccountDAO instance = new AccountDAO();
        instance.postNieuwAccount(account);
        
        String expResult = "WW1";
        String result = new AccountDAO().controleerInlog("User1");
        
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
        String result = instance.controleerInlog(gebruiker);
        assertEquals(expResult, result);
       
    }  
}
