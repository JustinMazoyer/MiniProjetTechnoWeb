/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import java.math.BigDecimal;
import java.util.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
    LigneFacade ligneDAO;

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
    public String validerPanier(@FormParam("totalcommande") BigDecimal totalcommande) {
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
        commande.setPort(totalcommande);
        commandeDAO.create(commande);
        LignePK lignepk = new LignePK();
        lignepk.setCommande(commande.getNumero());
        for (LignePanier ligne : panier.getLignesPanier()) {
            lignepk.setProduit(ligne.getProduit().getReference());
            Ligne nouvelleligne = new Ligne();
            nouvelleligne.setLignePK(lignepk);
            nouvelleligne.setQuantite(ligne.getQuantite());
            ligneDAO.create(nouvelleligne);
            nouvelleligne.setCommande1(commande);
        }
        panier.getLignesPanier().removeAll(panier.getLignesPanier());
        return "redirect:../client.html";
    }

}
