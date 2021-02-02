package Taha.Exam.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Film implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	private String titre;
	private double duree;
	private String realisateur;
	private String description;
	private String photo;
	private Date dateSortie;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Categorie categorie;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public double getDuree() {
		return duree;
	}


	public void setDuree(double duree) {
		this.duree = duree;
	}


	public String getRealisateur() {
		return realisateur;
	}


	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Date getDateSortie() {
		return dateSortie;
	}


	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Film(String titre, double duree, String realisateur, String description, String photo, Date dateSortie,
			Categorie categorie) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.dateSortie = dateSortie;
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", duree=" + duree + ", realisateur=" + realisateur
				+ ", description=" + description + ", photo=" + photo + ", dateSortie=" + dateSortie + ", categorie="
				+ categorie + "]";
	}
	
}
