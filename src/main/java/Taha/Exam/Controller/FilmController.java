package Taha.Exam.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Taha.Exam.Entity.Film;
import Taha.Exam.Repository.FilmRepository;
import Taha.Exam.Services.FilmServices;

@RestController
@RequestMapping("/film")
//@Secured(value = { "ROLE_ADMIN" })
public class FilmController {
	@Autowired
	FilmServices filmServices;
	private final FilmRepository PR;

	public FilmController(FilmRepository pR) {
		super();
		PR = pR;
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Film> listFilm() {
		return filmServices.findAll();
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@GetMapping("/getFilm/{id}")
	public Optional<Film> getFilmById(@PathVariable(value = "id") long id) {
		 //long artId = Integer.parseInt(artIdStr);
		return  PR.findById(id);

	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/addFilm", method = RequestMethod.POST)
	public Film ajouterfilm(@RequestBody Film prod) {
		return PR.save(prod);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/updateFilm", method = RequestMethod.POST)
	public Film updateFilm(@RequestBody Film film) {
		Optional<Film> optionelEntity = PR.findById(film.getId());
		Film prt = optionelEntity.get();
		prt.setTitre(film.getTitre());
		prt.setDuree(film.getDuree());
		prt.setRealisateur(film.getRealisateur());
		prt.setDescription(film.getDescription());
		prt.setPhoto(film.getPhoto());
		prt.setDateSortie(film.getDateSortie());
		
		return PR.save(prt);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/updateFilm/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Film> filmUpdate(@PathVariable(value = "id") long film_id,
			@RequestBody Film film_Details) {

		Optional<Film> optionelEntity = PR.findById(film_id);
		Film prt = optionelEntity.get();
		prt.setTitre(film_Details.getTitre());
		prt.setDuree(film_Details.getDuree());
		prt.setRealisateur(film_Details.getRealisateur());
		prt.setDescription(film_Details.getDescription());
		prt.setPhoto(film_Details.getPhoto());
		prt.setDateSortie(film_Details.getDateSortie());
		final Film updateFilm = PR.save(prt);
		return ResponseEntity.ok(updateFilm);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/deleteFilm/{id}", method = RequestMethod.DELETE)
	public String deleteFilm(@PathVariable(value = "id") long id) {
		filmServices.deleteFilmById(id);
		return "film suprimer!!";
	}

}
