package Taha.Exam.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Cinema implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	private String name;
	private double longitude;
	private double laltitude;
	private double altitude;
	private int nombreSalles;
	
/*
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Operation op;
*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Ville ville;
	
	
	
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Salle> salles = new HashSet<>();



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public double getLaltitude() {
		return laltitude;
	}






	public void setLaltitude(double laltitude) {
		this.laltitude = laltitude;
	}



	public double getAltitude() {
		return altitude;
	}



	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}



	public int getNombreSalles() {
		return nombreSalles;
	}



	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}



	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}



	public Set<Salle> getSalles() {
		return salles;
	}



	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}



	public Cinema(String name, double longitude, double laltitude, double altitude, int nombreSalles, Ville ville,
			Set<Salle> salles) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.laltitude = laltitude;
		this.altitude = altitude;
		this.nombreSalles = nombreSalles;
		this.ville = ville;
		this.salles = salles;
	}



	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", longitude=" + longitude + ", laltitude=" + laltitude
				+ ", altitude=" + altitude + ", nombreSalles=" + nombreSalles + ", ville=" + ville + ", salles="
				+ salles + "]";
	}
	
}
