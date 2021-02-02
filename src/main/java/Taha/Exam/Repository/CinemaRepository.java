package Taha.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Taha.Exam.Entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long>{
	public Cinema findCinemaById(long id);
}
