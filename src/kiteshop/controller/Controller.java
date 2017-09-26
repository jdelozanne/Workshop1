package kiteshop.controller;

import java.util.ArrayList;

import kiteshop.pojos.Account;
import kiteshop.pojos.Bestelling;
import kiteshop.pojos.Klant;
import kiteshop.pojos.Product;

public class Controller implements ControllerInterface {


	@Override
	public boolean checkLogin(String gebruikersNaam, String wachtWoord) {
		return true;
	}

	@Override
	public void addKlant(Klant k) {
		System.out.println("Klant " + k  +" wordt toegevoegd aan database");

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
		// TODO Auto-generated method stub

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
	public void addAccount(Account a) {
		// TODO Auto-generated method stub

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
