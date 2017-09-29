package kiteshop.daos;

import java.util.ArrayList;

import kiteshop.pojos.Klant;

public interface KlantDAOInterface {

	void addKlant(Klant klant);

	void deleteKlant(Klant klant);

	void updateKlant(Klant klant);

	ArrayList<Klant> showKlantenAchternaam(String achterNaam);

}