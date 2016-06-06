package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String naam;
	@NotNull
	@Valid
	@Embedded
	private Adres adres;
	@Min(0)
	private Integer omzet;
	
	// CONSTRUCTOR
	public Brouwer() {}
	
	public Brouwer(String naam, Adres adres) {
		this.id = -1;
		this.naam = naam;
		this.omzet = null;
		this.adres = adres;
	}
	
	public Brouwer(long id, String naam, Adres adres) {
		this.id = id;
		this.naam = naam;
		omzet = null;
		this.adres = adres;
	}
	
	public Brouwer(long id, String naam, Adres adres, Integer omzet) {
		this.id = id;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	// GETTERS & SETTERS
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public Integer getOmzet() {
		return omzet;
	}
	public Adres getAdres() {
		return adres;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setBrouwerNr(long id) {
		this.id = id;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	
	// OVERRIDDEN OBJECT METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Brouwer))
			return false;
		Brouwer other = (Brouwer) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brouwer [id=" + id + ", naam=" + naam + ", omzet=" + omzet + "]";
	}

	
	
}
