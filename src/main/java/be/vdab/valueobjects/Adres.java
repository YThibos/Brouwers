package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;


@Embeddable
public class Adres implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// MEMBER VARIABLES
	@NotBlank
	@SafeHtml
	private String straat;
	@NotBlank
	@SafeHtml
	private String huisNr;
	@NotNull
	private Integer postcode;
	@NotBlank
	@SafeHtml
	private String gemeente;
	
	// CONSTRUCTOR
	public Adres() {}
	
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
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
	public Integer getPostcode() {
		return postcode;
	}
	public String getGemeente() {
		return gemeente;
	}

}
