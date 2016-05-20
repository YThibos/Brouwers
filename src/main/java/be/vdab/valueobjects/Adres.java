package be.vdab.valueobjects;

import java.io.Serializable;

public class Adres implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// MEMBER VARIABLES
	private final String straat;
	private final String huisNr;
	private final String postcode;
	private final String gemeente;
	
	// CONSTRUCTOR
	public Adres(String straat, String huisNr, String postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	// GETTERS
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getGemeente() {
		return gemeente;
	}

}
