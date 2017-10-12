package kiteshop.daos;

import java.util.ArrayList;

import kiteshop.pojos.Klant;

public interface KlantDAOInterface {

    void createKlant(Klant klant);

    Klant readKlant(String achternaam);

    void updateKlant(Klant klant);

    void deleteKlant(Klant klant);
    
    void readAllKlanten();

    ArrayList<Klant> readSelectedKlantenAchternaam(String a);

}
