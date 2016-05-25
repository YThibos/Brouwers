package be.vdab.valueobjects;

import org.hibernate.validator.constraints.NotBlank;

public class ZoekenOpNaam {

	@NotBlank
	private String zoekstring;
	
	public ZoekenOpNaam() {}

	public String getZoekstring() {
		return zoekstring;
	}

	public void setZoekstring(String zoekstring) {
		this.zoekstring = zoekstring;
	}

}
