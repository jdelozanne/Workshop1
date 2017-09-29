/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

public class Klant {

    //ID hier al of pas in DAO, omdat ie daar wordt gegenereerd als primairy key?
    private int klantID;
    public int getKlantID() {
		return klantID;
	}

	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}

	private Adres adres;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String email;
    private String telefoonnummer;

    
    
    public String getEmail() {
		return email;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	
    public Klant() {
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    
    @Override
	public String toString(){
    	return voornaam + " " +tussenvoegsel+" " +achternaam+" "+email+" " +telefoonnummer+" "+adres;
    }

	public Klant(int klantID, Adres adres, String voornaam, String tussenvoegsel, String achternaam, String email,
			String telefoonnummer) {
		this.klantID = klantID;
		this.adres = adres;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.email = email;
		this.telefoonnummer = telefoonnummer;
	}

}
