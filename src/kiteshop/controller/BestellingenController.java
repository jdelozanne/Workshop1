package kiteshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import kiteshop.daos.BestelRegelDAO;
import kiteshop.daos.BestelRegelDAOInterface;
import kiteshop.daos.BestellingDAO;

import kiteshop.daos.BestellingDAOInterface;
import kiteshop.pojos.BestelRegel;
import kiteshop.pojos.Bestelling;
import kiteshop.test.ProjectLog;

public class BestellingenController {

    private final Logger logger = ProjectLog.getLogger();

    BestellingDAOInterface bestellingDAO;
    BestelRegelDAOInterface bestelRegelDAO;

    public BestellingenController() {
        bestellingDAO = new BestellingDAO();
        bestelRegelDAO = new BestelRegelDAO();
    }

    public void createBestelling(Bestelling bestelling) {
        bestellingDAO.createBestelling(bestelling);
        createBestelRegels(bestelling);
    }
    
    public void createBestelRegels(Bestelling bestelling){
        List<BestelRegel> bestelregels = new ArrayList<>();
        bestelregels = bestelling.getBestelling();
        for(BestelRegel b : bestelregels){
            bestelRegelDAO.createBestelRegel(b);
        }
        
    }

    public ArrayList<Bestelling> showSelectedBestellingen() {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteBestelling(Bestelling bestelling) {
        // TODO Auto-generated method stub
    }

}
