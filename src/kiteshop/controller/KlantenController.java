package kiteshop.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import kiteshop.daos.KlantDAO;
import kiteshop.daos.KlantDAOInterface;
import kiteshop.pojos.Klant;
import kiteshop.test.ProjectLog;

public class KlantenController {
	private final Logger logger = ProjectLog.getLogger();
	
	private KlantDAOInterface klantDAO;
	
	public KlantenController() {
		klantDAO = new KlantDAO();
	}
	

	


	public void addKlant(Klant klant) {
		logger.info("Klant " + klant + " wordt toegevoegd aan database");
		klantDAO.addKlant(klant);
	}

	 public ArrayList<Klant> showKlanten() {
	        // TODO Auto-generated method stub
	        return null;
	    }
	 
	 public ArrayList<Klant> showKlantenAchternaam(String achterNaam) {
	    	return klantDAO.showKlantenAchternaam(achterNaam);
	    }
	 
	
	
	 public void updateKlant(){
			
		}
	 
	 
	public void removeKlant(Klant klant) {
		klantDAO.deleteKlant(klant);
		logger.info("Deleting "+klant);

	}
	
	
	




	 


	 
}
