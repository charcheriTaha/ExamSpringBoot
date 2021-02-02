package Taha.Exam.ServicesInterfaces;

import java.util.List;

import Taha.Exam.Entity.Film;

public interface FilmServicesInterface {
	public Film getFilmById(long id);

	public String ajouterFilm(Film film);

	public String updateFilm(Film film);

	public String deleteFilm(Film film);

	public String deleteFilmById(long id);


	public List<Film> findAll();
}
