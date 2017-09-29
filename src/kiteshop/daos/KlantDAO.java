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
import java.util.ArrayList;


import kiteshop.pojos.Account;
import kiteshop.pojos.Klant;

/**
 *
 * @author julia
 */
public class KlantDAO implements KlantDAOInterface {
	Connection connection;
	
	PreparedStatement statement;
	ResultSet result;

	public KlantDAO() {
		this.connection = DBConnect.getConnection();
	}
	
	 
	/* (non-Javadoc)
	 * @see kiteshop.daos.KlantDAOInterface#addKlant(kiteshop.pojos.Klant)
	 */
	@Override
	public void addKlant(Klant klant) {
		try {
			String sql = "INSERT INTO klant" + "(KlantID, voornaam, tussenvoegsel,   achternaam, emailadres, straatnaam,   huisnummer, toevoeging, postcode,   plaats)" + "values (?,?,? ,?,?,? ,?,?,?, ?)";
			this.statement = connection.prepareStatement(sql);

			statement.setInt(1, 0);
			statement.setString(2, klant.getVoornaam());
			statement.setString(3, klant.getTussenvoegsel());
			statement.setString(4, klant.getAchternaam());
			statement.setString(5, klant.getEmail());
			statement.setString(6, klant.getAdres().getStraatnaam());
			statement.setInt(7, klant.getAdres().getHuisnummer());
			statement.setString(8, klant.getAdres().getToevoeging());
			statement.setString(9, klant.getAdres().getPostcode());
			statement.setString(10, klant.getAdres().getWoonplaats());

			statement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	/* (non-Javadoc)
	 * @see kiteshop.daos.KlantDAOInterface#removeKlant(kiteshop.pojos.Klant)
	 */
	@Override
	public void removeKlant(Klant klant) {
      

    }
	
	/* (non-Javadoc)
	 * @see kiteshop.daos.KlantDAOInterface#updateKlant(kiteshop.pojos.Klant)
	 */
	@Override
	public void updateKlant(Klant klant) {
	      

	    }

	/* (non-Javadoc)
	 * @see kiteshop.daos.KlantDAOInterface#showKlantenAchternaam(java.lang.String)
	 */
	@Override
	public ArrayList<Klant> showKlantenAchternaam(String achterNaam) {
     
        return null;
    }
	
	public static void main (String args[]){
		new KlantDAO().addKlant(new Klant());

	}

}
