package kiteshop.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sun.javafx.geom.transform.GeneralTransform3D;

import kiteshop.daos.AccountDAO;

import kiteshop.pojos.Account;
import kiteshop.pojos.Bestelling;
import kiteshop.pojos.Klant;
import kiteshop.pojos.Product;
import kiteshop.test.ProjectLog;

import static kiteshop.test.ProjectLog.*;

public class Controller implements ControllerInterface {
	private final Logger logger = ProjectLog.getLogger();
	
	
    @Override
    public boolean checkLogin(String gebruikersnaam, String wachtwoord) {
        AccountDAO check = new AccountDAO();
        logger.info("Gebruikers naam :"+ gebruikersnaam+ " Wachtwoord :" + wachtwoord + "Juiste wachtwoord :"+check.controleerInlog(gebruikersnaam)  );
        return check.controleerInlog(gebruikersnaam).equals(wachtwoord);
                
    }

    @Override
    public void addKlant(Klant k) {
    	
        System.out.println("Klant " + k + " wordt toegevoegd aan database");

    }

    @Override
    public void removeKlant(Klant k) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addProduct(Product p) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeProduct(Product p) {
        System.out.println("Product " + p + " wordt toegevoegd aan database");

    }

    @Override
    public void addBestelling(Bestelling b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeBestlling(Bestelling b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAccount(Account account) {
        AccountDAO accountdao = new AccountDAO();
        accountdao.postNieuwAccount(account);

    }

    @Override
    public void removeAccount(Account a) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<Klant> showKlanten() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Product> showProducten() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Bestelling> showBestellingen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Klant> showKlantenAchternaam(String achterNaam) {
        // TODO Auto-generated method stub
        return null;
    }

}
