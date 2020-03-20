package service;

import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.dto.StatsResult;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("service/unitesVendues")
public class StatisticsService {

	@Inject
	StatisticsDao dao;
	
	@GET @Path("categories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> unitesVenduesJSON() {
		return dao.unitesVenduesParCategorieDTO();
	}
        
        @GET @Path("chiffreaffaire")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> chiffreAffaireCategorie() {
		return dao.chiffreAffaireCategorieDTO();
	}
         @GET @Path("chiffreaffaire2")
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
            public List chiffreAffaireCategorie2() {
		List result = dao.chiffreAffaireCategorieDTO();
		return result;
	}
	
	@GET @Path("ca")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> ca(@QueryParam("saisieLe") Integer codeCategorie) {
		return dao.chiffreAffaireCategorie2(codeCategorie);
	}
        
        @GET @Path("chiffreaffairepays")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> chiffreAffaireParPays() {
		return dao.chiffreAffaireParPaysDTO();
	}
        
	@GET @Path("produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> produitsVendus(@QueryParam("code") Integer codeCategorie) {
		return dao.chiffreAffaireCategorie2(codeCategorie);
	}	

	@GET @Path("vector")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List unitesVenduesParCategorie() {
		List result = dao.unitesVenduesParCategorie();
		return result;
	}
        @GET @Path("chiffreaffairclient")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> chiffreAffaireClient() {
		return dao.chiffreAffaireClientDTO();
	}
}
