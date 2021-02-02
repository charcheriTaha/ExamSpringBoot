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

import Taha.Exam.Entity.Categorie;
import Taha.Exam.Repository.CategorieRepository;
import Taha.Exam.Services.CategorieServices;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

		@Autowired
		CategorieServices categorieServices;
		private final CategorieRepository PR;

		public CategorieController(CategorieRepository pR) {
			super();
			PR = pR;
		}
		@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public List<Categorie> listCategorie() {
			return categorieServices.findAll();
		}
		@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
		@GetMapping("/getCategorie/{id}")
		public Optional<Categorie> getCategorieById(@PathVariable(value = "id") long id) {
			 //long artId = Integer.parseInt(artIdStr);
			return  PR.findById(id);

		}
		@Secured(value = { "ROLE_ADMIN" })
		@RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
		public Categorie ajoutercategorie(@RequestBody Categorie prod) {
			return PR.save(prod);
		}
		@Secured(value = { "ROLE_ADMIN" })
		@RequestMapping(value = "/updateCategorie", method = RequestMethod.POST)
		public Categorie updateCategorie(@RequestBody Categorie categorie) {
			Optional<Categorie> optionelEntity = PR.findById(categorie.getId());
			Categorie prt = optionelEntity.get();
			prt.setName(categorie.getName());
			return PR.save(prt);
		}
		@Secured(value = { "ROLE_ADMIN" })
		@RequestMapping(value = "/updateCategorie/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Categorie> categorieUpdate(@PathVariable(value = "id") long categorie_id,
				@RequestBody Categorie categorie_Details) {

			Optional<Categorie> optionelEntity = PR.findById(categorie_id);
			Categorie prt = optionelEntity.get();
			prt.setName(categorie_Details.getName());
			
			final Categorie updateCategorie = PR.save(prt);
			return ResponseEntity.ok(updateCategorie);
		}
		@Secured(value = { "ROLE_ADMIN"})
		@RequestMapping(value = "/deleteCategorie/{id}", method = RequestMethod.DELETE)
		public String deleteCategorie(@PathVariable(value = "id") long id) {
			categorieServices.deleteCategorieById(id);
			return "categorie suprimer!!";
		}

	

}
