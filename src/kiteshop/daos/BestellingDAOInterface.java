package kiteshop.daos;

import java.util.ArrayList;
import kiteshop.pojos.Bestelling;

public interface BestellingDAOInterface {
    
    int createBestelling(Bestelling bestelling);

    void readBestelling(int bestellingID);

    void updateBestelling(Bestelling bestelling);

    void deleteBestelling(Bestelling bestelling);

}