package Taha.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Taha.Exam.Entity.Cinema;
import Taha.Exam.Entity.Film;
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	public Film findFilmById(long id);
}
