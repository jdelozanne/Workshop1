package kiteshop.controller;

import java.util.ArrayList;
import java.util.logging.Logger;
import kiteshop.daos.BestellingDAO;

import kiteshop.daos.BestellingDAOInterface;
import kiteshop.pojos.Bestelling;
import kiteshop.test.ProjectLog;

public class BestellingenController {

    private final Logger logger = ProjectLog.getLogger();

    BestellingDAOInterface bestellingDAO;

    public BestellingenController() {
        bestellingDAO = new BestellingDAO();
    }

    public int createBestelling(Bestelling bestelling) {
        return bestellingDAO.createBestelling(bestelling);
    }

    public ArrayList<Bestelling> showSelectedBestellingen() {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteBestelling(Bestelling bestelling) {
        // TODO Auto-generated method stub
    }

}
