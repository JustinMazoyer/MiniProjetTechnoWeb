/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.Produit;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Justin
 */
@Controller
@Path("PanierClient")
@View("PanierClient.jsp")
public class PanierController {

    @Inject
    Models model;

    @Inject
    Panier panier;

    @Inject
    ProduitFacade produit;

    @Inject
    CommandeFacade commandeDAO;

    @Inject
    ClientFacade dao;
    @Inject
    private ClientInfo player;

    @GET
    public void show() {
        model.put("panier", panier);
    }

    @POST
    public String validerPanier() {
        Commande commande = new Commande();
        Client c = dao.find(player.getCode());
        commande.setClient(c);
        commande.setDestinataire(c.getSociete());
        commande.setAdresseLivraison(c.getAdresse());
        commande.setCodePostalLivrais(c.getCodePostal());
        commande.setVilleLivraison(c.getVille());
        commande.setRegionLivraison(c.getRegion());
        commande.setPaysLivraison(c.getPays());
        commande.setEnvoyeeLe(new Date());
        commande.setSaisieLe(new Date());
        commande.setRemise(BigDecimal.ZERO);
        commandeDAO.create(commande);
        return "redirect:../client.html";
    }

}
