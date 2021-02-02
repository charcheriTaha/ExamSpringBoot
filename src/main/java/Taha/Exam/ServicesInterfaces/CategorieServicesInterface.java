package Taha.Exam.ServicesInterfaces;

import java.util.List;

import Taha.Exam.Entity.Categorie;



public interface CategorieServicesInterface {
	
	public Categorie getCategorieById(long id);

	public String ajouterCategorie(Categorie categorie);

	public String updateCategorie(Categorie categorie);

	public String deleteCategorie(Categorie categorie);

	public String deleteCategorieById(long id);


	public List<Categorie> findAll();
}
