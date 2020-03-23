package service;

import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.dto.StatsResult;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import util.HtmlDate;

@Path("service/unitesVendues")
public class StatisticsService {

    @Inject
    StatisticsDao dao;

    @GET
    @Path("categories")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<StatsResult> unitesVenduesJSON() {
        return dao.unitesVenduesParCategorieDTO();
    }

    @GET
    @Path("chiffreaffaire")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<StatsResult> chiffreAffaireCategorie() {
        return dao.chiffreAffaireCategorieDTO();
    }

    @GET
    @Path("chiffreaffaireDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatsResult> chiffreAffaireCategorieDate(
            @QueryParam("minDate") HtmlDate minDate,
            @QueryParam("maxDate") HtmlDate maxDate) {
        return dao.chiffreAffaireCategorieDTO_DATE(minDate, maxDate);
    }

    @GET
    @Path("chiffreaffairepays")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<StatsResult> chiffreAffaireParPays() {
        return dao.chiffreAffaireParPaysDTO();
    }

    @GET
    @Path("chiffreaffairepaysDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatsResult> chiffreAffairePaysDate(
            @QueryParam("minDate") HtmlDate minDate,
            @QueryParam("maxDate") HtmlDate maxDate) {
        return dao.chiffreAffairePaysDTO_DATE(minDate, maxDate);
    }

    @GET
    @Path("vector")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List unitesVenduesParCategorie() {
        List result = dao.unitesVenduesParCategorie();
        return result;
    }

    @GET
    @Path("chiffreaffaireclient")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<StatsResult> chiffreAffaireClient() {
        return dao.chiffreAffaireClientDTO();
    }

    @GET
    @Path("chiffreaffaireclientDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatsResult> chiffreAffaireClientDate(
            @QueryParam("minDate") HtmlDate minDate,
            @QueryParam("maxDate") HtmlDate maxDate) {
        return dao.chiffreAffaireClientDTO_DATE(minDate, maxDate);
    }

    @GET
    @Path("produits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StatsResult> produitsVendus(@QueryParam("test") Integer codeCategorie) {
        return dao.produitsVendusPour(codeCategorie);
    }
}
