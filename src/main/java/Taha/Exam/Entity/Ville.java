package Taha.Exam.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ville implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	private String name;
	private double longitude;
	private double laltitude;
	private double altitude;

	@OneToMany(mappedBy = "ville", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Cinema> cinemas = new HashSet<>();
}
