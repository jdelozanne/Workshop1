package kiteshop.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sun.javafx.geom.transform.GeneralTransform3D;

import kiteshop.daos.*;

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
    public void addKlant(Klant klant) {
    	logger.info("Klant " + klant + " wordt toegevoegd aan database");
    	KlantDAOInterface klantDAO = new KlantDAO();
    	klantDAO.addKlant(klant);

    }

    @Override
    public void removeKlant(Klant klant) {
    	
    	KlantDAOInterface klantDAO = new KlantDAO();
    	klantDAO.deleteKlant(klant);
    	
    	logger.info("Deleting "+klant);

    }

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeProduct(Product product) {
        System.out.println("Product " + product + " wordt toegevoegd aan database");

    }

    @Override
    public void addBestelling(Bestelling bestelling) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeBestlling(Bestelling bestelling) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAccount(Account account) {
        AccountDAO accountdao = new AccountDAO();
        accountdao.postNieuwAccount(account);

    }

    @Override
    public void removeAccount(Account account) {
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
    	KlantDAOInterface klantDAO = new KlantDAO();
    	return klantDAO.showKlantenAchternaam(achterNaam);
    }

    public static void main(String args[]){
    	Klant klant = new Klant();
    	klant.setKlantID(1);
    			
    	new Controller().removeKlant(klant);
    }
}
