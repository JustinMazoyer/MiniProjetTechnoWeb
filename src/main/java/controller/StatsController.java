package controller;

import comptoirs.model.dao.StatisticsDao;
import java.util.Date;
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
