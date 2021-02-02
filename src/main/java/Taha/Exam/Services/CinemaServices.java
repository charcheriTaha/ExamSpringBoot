package Taha.Exam.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taha.Exam.Entity.Categorie;
import Taha.Exam.Entity.Cinema;
import Taha.Exam.Repository.CinemaRepository;
import Taha.Exam.ServicesInterfaces.CinemaServicesInterface;

@Transactional
@Service("cinemaServices")
public class CinemaServices implements CinemaServicesInterface{

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Cinema getCinemaById(long id) {
		// TODO Auto-generated method stub
		return cinemaRepository.findCinemaById(id);
	}

	@Override
	public String ajouterCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		cinemaRepository.save(cinema);
		return "Cinema Enregistré";
	}

	@Override
	public String updateCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		cinemaRepository.delete(cinema);
		return "Cinema supprimé";
	}

	@Override
	public String deleteCinemaById(long id) {
		// TODO Auto-generated method stub
		cinemaRepository.deleteById(id);
		return "Cinema supprimé";
	}

	

	



	@Override
	public List<Cinema> findAll() {
		// TODO Auto-generated method stub
		List<Cinema> cinemas = new ArrayList<Cinema>();
		for (Cinema cinema : cinemaRepository.findAll())
			cinemas.add(cinema);
		return cinemas;
	}

	
}
