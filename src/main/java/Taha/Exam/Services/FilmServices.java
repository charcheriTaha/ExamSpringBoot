package Taha.Exam.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taha.Exam.Entity.Film;
import Taha.Exam.Repository.FilmRepository;
import Taha.Exam.ServicesInterfaces.FilmServicesInterface;

@Transactional
@Service("filmServices")
public class FilmServices implements FilmServicesInterface{

	@Autowired
	FilmRepository filmRepository;

	@Override
	public Film getFilmById(long id) {
		// TODO Auto-generated method stub
		return filmRepository.findFilmById(id);
	}

	@Override
	public String ajouterFilm(Film film) {
		// TODO Auto-generated method stub
		filmRepository.save(film);
		return "Film Enregistré";
	}

	@Override
	public String updateFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFilm(Film film) {
		// TODO Auto-generated method stub
		filmRepository.delete(film);
		return "Film supprimé";
	}

	@Override
	public String deleteFilmById(long id) {
		// TODO Auto-generated method stub
		filmRepository.deleteById(id);
		return "Film supprimé";
	}

	

	



	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		List<Film> films = new ArrayList<Film>();
		for (Film film : filmRepository.findAll())
			films.add(film);
		return films;
	}
}