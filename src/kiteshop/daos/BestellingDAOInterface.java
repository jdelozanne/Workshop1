package kiteshop.daos;

import java.util.ArrayList;
import kiteshop.pojos.Bestelling;

public interface BestellingDAOInterface {
    
    void createBestelling(Bestelling bestelling);

    void readBestelling(Bestelling bestelling);

    void updateBestelling(Bestelling bestelling);

    void deleteBestelling(Bestelling bestelling);

}