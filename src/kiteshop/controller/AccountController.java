package kiteshop.controller;

import java.util.logging.Logger;

import kiteshop.daos.AccountDAO;
import kiteshop.daos.AccountDAOInterface;
import kiteshop.pojos.Account;
import kiteshop.test.ProjectLog;

public class AccountController {
	private final Logger logger = ProjectLog.getLogger();

	
	AccountDAOInterface accountDAO;
	
	
	
	 public void addAccount(Account account) {
	        accountDAO.postNieuwAccount(account);
    }
	
	
	 public boolean checkLogin(String gebruikersnaam, String wachtwoord) {
	  
	        logger.info("Gebruikers naam :"+ gebruikersnaam+ " Wachtwoord :" + wachtwoord + "Juiste wachtwoord :"+accountDAO.controleerInlog(gebruikersnaam)  );
	        return accountDAO.controleerInlog(gebruikersnaam).equals(wachtwoord);
	                
	    }


	 
	 public void removeAccount(Account account) {
	        // TODO Auto-generated method stub

	    }
	 
	 
	 
	 public AccountController() {
			accountDAO = new AccountDAO();
		}



}
