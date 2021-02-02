package Taha.Exam.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taha.Exam.Entity.Categorie;
import Taha.Exam.Repository.CategorieRepository;
import Taha.Exam.ServicesInterfaces.CategorieServicesInterface;
@Transactional
@Service("categorieServices")
public class CategorieServices implements CategorieServicesInterface{

	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie getCategorieById(long id) {
		// TODO Auto-generated method stub
		return categorieRepository.findCategorieById(id);
	}

	@Override
	public String ajouterCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieRepository.save(categorie);
		return "Categorie Enregistré";
	}

	@Override
	public String updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieRepository.delete(categorie);
		return "Categorie supprimé";
	}

	@Override
	public String deleteCategorieById(long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
		return "Categorie supprimé";
	}

	

	



	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		List<Categorie> categories = new ArrayList<Categorie>();
		for (Categorie categorie : categorieRepository.findAll())
			categories.add(categorie);
		return categories;
	}
}
