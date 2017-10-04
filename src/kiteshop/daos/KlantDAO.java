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

    PreparedStatement statement;
    ResultSet result;

    public KlantDAO() {
        this.connection = DBConnect.getConnection();
    }

    @Override
    public void createKlant(Klant klant) {
        try {
            String sql = "INSERT INTO klant" + "(KlantID, voornaam, tussenvoegsel, achternaam, "
                    + "emailadres, straatnaam, huisnummer, toevoeging, postcode, plaats, telefoon)" 
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            this.statement = connection.prepareStatement(sql);

            statement.setInt(1, 0);
            statement.setString(2, klant.getVoornaam());
            statement.setString(3, klant.getTussenvoegsel());
            statement.setString(4, klant.getAchternaam());
            statement.setString(5, klant.getAdres().getEmail());
            statement.setString(6, klant.getAdres().getStraatnaam());
            statement.setInt(7, klant.getAdres().getHuisnummer());
            statement.setString(8, klant.getAdres().getToevoeging());
            statement.setString(9, klant.getAdres().getPostcode());
            statement.setString(10, klant.getAdres().getWoonplaats());
            statement.setInt(11, klant.getAdres().getTelefoon());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readKlant(Klant klant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            statement.setString(5, klant.getAdres().getEmail());
            statement.setString(6, klant.getAdres().getStraatnaam());
            statement.setInt(7, klant.getAdres().getHuisnummer());
            statement.setString(8, klant.getAdres().getToevoeging());
            statement.setString(9, klant.getAdres().getPostcode());
            statement.setString(10, klant.getAdres().getWoonplaats());
            statement.setInt(11, klant.getAdres().getTelefoon());

            statement.execute();

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
            statement = connection.prepareStatement("select * from klant where achternaam = ?");

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
                adres.setEmail(emailadres);
                klant.setAdres(adres);

                selectionKlanten.add(klant);
                System.out.println(voornaam + tussenvoegsel + achternaam + emailadres + straatnaam + huismummer + toevoeging + postcode + woonplaats);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return selectionKlanten;
    }

    public static void main(String args[]) {
        new KlantDAO().readSelectedKlantenAchternaam("Lol2");
    }

}
