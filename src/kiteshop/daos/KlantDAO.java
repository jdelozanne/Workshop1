/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import kiteshop.pojos.Account;
import kiteshop.pojos.Adres;
import kiteshop.pojos.Klant;
import kiteshop.test.ProjectLog;

/**
 *
 * @author julia
 */
public class KlantDAO implements KlantDAOInterface {

    private final Logger logger = ProjectLog.getLogger();

    Connection connection;

    
    

    public KlantDAO() {
        this.connection = DBConnect.getConnection();
    }

    @Override
    public void createKlant(Klant klant) {
        try {
            String sql1 = "INSERT INTO klant" + "(KlantID, voornaam, tussenvoegsel, achternaam, "
                    + "emailadres, telefoonnummer)" 
                    + "values (?,?,?,?,?, ?)";
            
            PreparedStatement statement1 = connection.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);

            statement1.setInt(1, 0);
            statement1.setString(2, klant.getVoornaam());
            statement1.setString(3, klant.getTussenvoegsel());
            statement1.setString(4, klant.getAchternaam());
            statement1.setString(5, klant.getEmail());
            statement1.setString(6, klant.getTelefoonnummer());
            statement1.execute();
            
            ResultSet result = statement1.getGeneratedKeys();
            int generatedkey = 0;
            if (result.isBeforeFirst()) {
            	result.next();
                generatedkey = result.getInt(1);
                logger.info("Klant gegevens verwerkt, key gegenereerd: " +generatedkey);
            }
            
            //Creeeren van het bezoekadres
            String sql2 = "INSERT INTO `juliaworkshop`.`adres` (`adresID`, `klantIDadres`, `straatnaam`, `huisnummer`, `toevoeging`, `postcode`, `woonplaats`, `adres_type` ) "
            		+ "VALUES (?,?,?,?, ?,?, ?, ?)";
            
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1, 0);
            statement2.setInt(2, generatedkey);
            statement2.setString(3, klant.getBezoekAdres().getStraatnaam());
            statement2.setInt(4, klant.getBezoekAdres().getHuisnummer());
            statement2.setString(5, klant.getBezoekAdres().getToevoeging());
            statement2.setString(6, klant.getBezoekAdres().getPostcode());
            statement2.setString(7, klant.getBezoekAdres().getWoonplaats());
            statement2.setString(8, klant.getBezoekAdres().getAdresType().toString());
            statement2.execute();
            
          //Creeeren van het factuuradres
            String sql3 = "INSERT INTO `juliaworkshop`.`adres` (`klantIDadres`, `straatnaam`, `huisnummer`, `toevoeging`, `postcode`, `woonplaats`, `adres_type`) "
            		+ "VALUES (?,?,?,?,?,?, ?)";
            
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            
            statement3.setInt(1, generatedkey);
            statement3.setString(2, klant.getFactuurAdres().getStraatnaam());
            statement3.setInt(3, klant.getFactuurAdres().getHuisnummer());
            statement3.setString(4, klant.getFactuurAdres().getToevoeging());
            statement3.setString(5, klant.getFactuurAdres().getPostcode());
            statement3.setString(6, klant.getFactuurAdres().getWoonplaats());
            statement3.setString(7, klant.getFactuurAdres().getAdresType().toString());
            statement3.execute();
            
            
            
            /*
            
            
            PreparedStatement statement2 = connection.prepareStatement()
            
            
            statement1.setString(6, klant.getAdres().getStraatnaam());
            statement1.setInt(7, klant.getAdres().getHuisnummer());
            statement1.setString(8, klant.getAdres().getToevoeging());
            statement1.setString(9, klant.getAdres().getPostcode());
            statement1.setString(10, klant.getAdres().getWoonplaats());

            */

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    @Override
    public Klant readKlant(String achternaam) {
        Klant k = new Klant();
        try {
            String query = "Select * from klant where achternaam = ?";
           PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, achternaam);

            ResultSet result = statement.executeQuery();
            
            while(result.next()){

            k.setKlantID(result.getInt(1));
            k.setVoornaam(result.getString(2));
            k.setTussenvoegsel(result.getString(3));
            k.setAchternaam(result.getString(4));
            }
            


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return k;
    }

    @Override
    public void updateKlant(Klant klant) {
        try {

            String sql = " UPDATE klant " + "(KlantID, voornaam, tussenvoegsel, achternaam, "
                    + "emailadres, straatnaam, huisnummer, toevoeging, postcode, plaats, telefoonnummer )" 
                    + "values (?,?,?,?,?,?,?,?,?,?,?)" + "where KlantID = " + klant.getKlantID();
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, 0);
            statement.setString(2, klant.getVoornaam());
            statement.setString(3, klant.getTussenvoegsel());
            statement.setString(4, klant.getAchternaam());
            statement.setString(5, klant.getEmail());
            
            
            statement.setString(11, klant.getTelefoonnummer());

            statement.execute();
            
            

            statement.setString(6, klant.getBezoekAdres().getStraatnaam());
            statement.setInt(7, klant.getBezoekAdres().getHuisnummer());
            statement.setString(8, klant.getBezoekAdres().getToevoeging());
            statement.setString(9, klant.getBezoekAdres().getPostcode());
            statement.setString(10, klant.getBezoekAdres().getWoonplaats());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteKlant(Klant klant) {
        try {
            Statement statement = connection.createStatement();

            logger.info("Deleting");
            String sql = " DELETE FROM klant "
                    + " WHERE KlantID = " + klant.getKlantID();

            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public ArrayList<Klant> readSelectedKlantenAchternaam(String a) {

        ArrayList<Klant> selectionKlanten = new ArrayList<Klant>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from klant where achternaam = ?");

            statement.setString(1, a);

            ResultSet rSet = statement.executeQuery();

            while (rSet.next()) {
                int KlantID = rSet.getInt(1);
                String voornaam = rSet.getString(2);
                String tussenvoegsel = rSet.getString(3);
                String achternaam = rSet.getString(4);
                String emailadres = rSet.getString(5);
                String straatnaam = rSet.getString(6);
                int huismummer = rSet.getInt(7);
                String toevoeging = rSet.getString(8);
                String postcode = rSet.getString(9);
                String woonplaats = rSet.getString(10);
                String telefoonnummer = rSet.getString(11);

                Adres adres = new Adres();
                adres.setStraatnaam(straatnaam);
                adres.setHuisnummer(huismummer);
                adres.setToevoeging(toevoeging);
                adres.setPostcode(postcode);
                adres.setWoonplaats(woonplaats);
                Klant klant = new Klant();
                klant.setVoornaam(voornaam);
                klant.setTussenvoegsel(tussenvoegsel);
                klant.setAchternaam(achternaam);
                klant.setEmail(emailadres);
                klant.setBezoekAdres(adres);

                selectionKlanten.add(klant);
                System.out.println(voornaam + tussenvoegsel + achternaam + emailadres + straatnaam + huismummer + toevoeging + postcode + woonplaats);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return selectionKlanten;
    }
    
    @Override
    public void readAllKlanten(){
        ArrayList <Klant> allKlanten = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from klant");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Klant k = new Klant();
                k.setKlantID(result.getInt(1));
                k.setVoornaam(result.getString(2));
                k.setTussenvoegsel(result.getString(3));
                k.setAchternaam(result.getString(4));
        
            allKlanten.add(k);
            }
        
    }catch(SQLException ex){
        
    }
        displayKlanten(allKlanten);
        
    }
    
    public void displayKlanten(ArrayList <Klant> klanten){
        for(Klant k : klanten){
            System.out.println(k.toString());
        }
    }

    public static void main(String args[]) {
        new KlantDAO().readSelectedKlantenAchternaam("Lol2");
    }


}
