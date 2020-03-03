/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Justin
 */
@Controller
@Path("VisualiserCommande")
@View("VisualiserCommande.jsp")
public class VisualiserCommande {

    @Inject
    ClientFacade dao;

    @Inject
    BindingResult formValidationErrors;

    @Inject
    Models models;
    @Inject
    private ClientInfo player;

    @GET
    public void afficheCommandePourLeClient(@QueryParam("code") String codeClient) {
        codeClient = player.getCode();
        Client c = dao.find(codeClient);
        c.getCommandeCollection();
        models.put("client", c);
    }

}
