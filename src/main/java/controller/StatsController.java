package controller;

import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.entity.Commande;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@Controller
@Path("statsProduitsPourCategorie")
@View("statsProduitsPourCategorie.jsp")
public class StatsController {
	@Inject 
	CommandeFacade dao;
//    	@Inject 
//	CategorieFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		List<Commande> toutesLesCommandes = dao.findAll();
		models.put("commandes", toutesLesCommandes);
//		List<Categorie> toutesLesCategories = dao.findAll();
//		models.put("categories", toutesLesCategories);
	}
}
