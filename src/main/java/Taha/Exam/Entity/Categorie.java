package Taha.Exam.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Categorie implements Serializable  {
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "IdCategorie")
	private long id;

	@NotNull
	@Column(name = "NomCategorie")
	private String name;
	
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Film> films = new HashSet<>();

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

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public Categorie(String name, Set<Film> films) {
		super();
		this.name = name;
		this.films = films;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", name=" + name + ", films=" + films + "]";
	}
	
}
