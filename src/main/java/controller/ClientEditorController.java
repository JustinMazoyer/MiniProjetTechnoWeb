/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Client;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author jmazoyer
 */
@Controller
@Path("cientEditor")
@View("clientEditor.jsp")
public class ClientEditorController {
    @Inject
	ClientFacade dao;

	@Inject
	BindingResult formValidationErrors;
	
	@Inject
	Models models;

	@GET
	public void show() {
		models.put("clients", dao.findAll());
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.ALL)	
	public void create(@FormParam("Code") String code,
		@FormParam("Adresse") String adresse
                ){
		if ( ! formValidationErrors.isFailed()) { // Pas d'erreurs de saisie dans le formulaire
			// On crée la nouvelle catégorie
			Client nouveau = new Client();
			nouveau.setCode(code);
			nouveau.setAdresse(adresse);
			// On l'enregistre dans la base
			try {
				dao.create(nouveau);
			} catch (EJBException e) {
				// Erreur possible : il existe déjà une catégorie avec ce libellé
				Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
				// On pourrait examiner l'exception pour vérifier sa cause exacte
				models.put("databaseErrorMessage", "Le client '" + code + "' existe déjà");
			}
		}
		models.put("validationErrors", formValidationErrors);
		models.put("clients", dao.findAll());
	}	
    
}
