/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Nicolas
 */
@Controller
@Path("CAClient")
@View("CAClient.jsp")
public class CAClientController {
     @Inject 
	CommandeFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		List<Commande> toutesLesCommandes = dao.findAll();
		models.put("commandes", toutesLesCommandes);
	}
}
