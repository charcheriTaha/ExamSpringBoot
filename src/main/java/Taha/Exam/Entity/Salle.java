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
public class Salle extends Cinema implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	private String name;
	private int nombrePlaces;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Cinema cinema;

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

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Salle(String name, double longitude, double laltitude, double altitude, int nombreSalles, Ville ville,
			Set<Salle> salles, String name2, int nombrePlaces, Cinema cinema) {
		super(name, longitude, laltitude, altitude, nombreSalles, ville, salles);
		name = name2;
		this.nombrePlaces = nombrePlaces;
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", name=" + name + ", nombrePlaces=" + nombrePlaces + ", cinema=" + cinema + "]";
	}

}
