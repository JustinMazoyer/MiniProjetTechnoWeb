/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.entity.Commande;
import java.util.Date;
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
    StatisticsDao dao;

    @Inject
    Models models;

    @GET
    public void show() {
        Date min = dao.datePlusAncienneCommande();
        Date max = dao.datePlusRecenteCommande();
        models.put("minDate", min);
        models.put("maxDate", max);
    }
}
