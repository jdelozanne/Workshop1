package kiteshop.daos;

import java.util.ArrayList;

import kiteshop.pojos.Klant;

public interface KlantDAOInterface {

    void createKlant(Klant klant);

    void readKlant(Klant klant);

    void updateKlant(Klant klant);

    void deleteKlant(Klant klant);

    ArrayList<Klant> readSelectedKlantenAchternaam(String a);

}
