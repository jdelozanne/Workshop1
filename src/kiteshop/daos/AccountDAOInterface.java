package kiteshop.daos;

import kiteshop.pojos.Account;

//test test

public interface AccountDAOInterface {

	void postNieuwAccount(Account account);

	String controleerInlog(String gebruiker);

}