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
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.Produit;
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
@Path("ModifierQuantite")
@View("PanierClient.jsp")
public class ModifierQuantite {

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

    @GET
    public void show() {
        model.put("panier", panier);
    }

    @POST
    public void ModifierQuantite(@FormParam("modifier") Integer modifier, @FormParam("quantité") short quantité) {
        Produit p = produit.find(modifier);
        if (p.getUnitesEnStock() >= quantité) {
            for (LignePanier ligne : panier.getLignesPanier()) {
                if (ligne.getProduit().getReference().equals(p.getReference())) {
                    ligne.setQuantite(quantité);
                    break;
                }
            }
        }
        model.put("panier", panier);
    }
}
