package Taha.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Taha.Exam.Entity.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	public Categorie findCategorieById(long id);
}
