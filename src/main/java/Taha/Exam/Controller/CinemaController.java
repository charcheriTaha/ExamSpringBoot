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

import Taha.Exam.Entity.Cinema;
import Taha.Exam.Repository.CinemaRepository;
import Taha.Exam.Services.CinemaServices;


@RestController
@RequestMapping("/cinema")
//@Secured(value = { "ROLE_ADMIN" })
public class CinemaController {
	@Autowired
	CinemaServices cinemaServices;
	private final CinemaRepository PR;

	public CinemaController(CinemaRepository pR) {
		super();
		PR = pR;
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Cinema> listCinema() {
		return cinemaServices.findAll();
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@GetMapping("/getCinema/{id}")
	public Optional<Cinema> getCinemaById(@PathVariable(value = "id") long id) {
		 //long artId = Integer.parseInt(artIdStr);
		return  PR.findById(id);

	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/addCinema", method = RequestMethod.POST)
	public Cinema ajoutercinema(@RequestBody Cinema prod) {
		return PR.save(prod);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/updateCinema", method = RequestMethod.POST)
	public Cinema updateCinema(@RequestBody Cinema cinema) {
		Optional<Cinema> optionelEntity = PR.findById(cinema.getId());
		Cinema prt = optionelEntity.get();
		prt.setName(cinema.getName());
		prt.setLongitude(cinema.getLongitude());
		prt.setLaltitude(cinema.getLaltitude());
		prt.setAltitude(cinema.getAltitude());
		prt.setNombreSalles(cinema.getNombreSalles());
		
		return PR.save(prt);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/updateCinema/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cinema> cinemaUpdate(@PathVariable(value = "id") long cinema_id,
			@RequestBody Cinema cinema_Details) {

		Optional<Cinema> optionelEntity = PR.findById(cinema_id);
		Cinema prt = optionelEntity.get();
		prt.setName(cinema_Details.getName());
		prt.setLongitude(cinema_Details.getLongitude());
		prt.setLaltitude(cinema_Details.getLaltitude());
		prt.setAltitude(cinema_Details.getAltitude());
		prt.setNombreSalles(cinema_Details.getNombreSalles());

		final Cinema updateCinema = PR.save(prt);
		return ResponseEntity.ok(updateCinema);
	}
	@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/deleteCinema/{id}", method = RequestMethod.DELETE)
	public String deleteCinema(@PathVariable(value = "id") long id) {
		cinemaServices.deleteCinemaById(id);
		return "cinema suprimer!!";
	}

	

}
