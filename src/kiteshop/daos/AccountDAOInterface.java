package kiteshop.daos;

import kiteshop.pojos.Account;

public interface AccountDAOInterface {

	void postNieuwAccount(Account account);

	String controleerInlog(String gebruiker);

}