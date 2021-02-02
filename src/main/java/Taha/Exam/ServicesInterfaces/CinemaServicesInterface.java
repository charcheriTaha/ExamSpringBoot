package Taha.Exam.ServicesInterfaces;

import java.util.List;

import Taha.Exam.Entity.Cinema;
import Taha.Exam.Entity.Cinema;

public interface CinemaServicesInterface {
	public Cinema getCinemaById(long id);

	public String ajouterCinema(Cinema cinema);

	public String updateCinema(Cinema cinema);

	public String deleteCinema(Cinema cinema);

	public String deleteCinemaById(long id);

	public List<Cinema> findAll();
}
