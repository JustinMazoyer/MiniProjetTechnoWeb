package comptoirs.model.dao;

import comptoirs.model.dto.StatsResult;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.HtmlDate;

@Stateless
public class StatisticsDao {

    private static final String UNITS_SOLD
            = "SELECT cat.libelle, SUM(li.quantite) "
            + "FROM Categorie cat "
            + "JOIN cat.produitCollection p "
            + "JOIN p.ligneCollection li "
            + "GROUP BY cat.libelle";

    private static final String CA_CATEGORIE_DTO
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(cat.libelle, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Categorie cat "
            + "JOIN cat.produitCollection p "
            + "JOIN p.ligneCollection li "
            + "GROUP BY cat.libelle";

    private static final String CA_CATEGORIE_DTO_DATE
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(cat.libelle, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Categorie cat "
            + "JOIN cat.produitCollection p "
            + "JOIN p.ligneCollection li "
            + "JOIN li.commande1 c "
            + "WHERE c.saisieLe between :minDate and :maxDate "
            + "GROUP BY cat.libelle ";

    private static final String UNIT_SOLDS_DTO
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(cat.libelle, SUM(li.quantite)) "
            + "FROM Categorie cat "
            + "JOIN cat.produitCollection p "
            + "JOIN p.ligneCollection li "
            + "GROUP BY cat.libelle";

    private static final String PRODUCTS_SOLDS_DTO
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(p.nom, SUM(li.quantite)) "
            + "FROM Produit p "
            + "JOIN p.categorie cat "
            + "JOIN p.ligneCollection li "
            + "WHERE cat.code = :test "
            + "GROUP BY p.nom ";

    private static final String CA_PAYS_DTO
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(c.paysLivraison, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Commande c "
            + "JOIN c.ligneCollection li "
            + "JOIN li.produit1 p "
            + "GROUP BY c.paysLivraison";

    private static final String CA_PAYS_DTO_DATE
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(c.paysLivraison, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Commande c "
            + "JOIN c.ligneCollection li "
            + "JOIN li.produit1 p "
            + "WHERE c.saisieLe between :minDate and :maxDate "
            + "GROUP BY c.paysLivraison";

    private static final String CA_CLIENT_DTO
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(cl.contact, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Client cl "
            + "JOIN cl.commandeCollection c "
            + "JOIN c.ligneCollection li "
            + "JOIN li.produit1 p "
            + "GROUP BY cl.contact";

    private static final String CA_CLIENT_DTO_DATE
            = "SELECT new comptoirs.model.dto.StatsResult"
            + "(cl.contact, SUM(p.prixUnitaire*li.quantite)) "
            + "FROM Client cl "
            + "JOIN cl.commandeCollection c "
            + "JOIN c.ligneCollection li "
            + "JOIN li.produit1 p "
            + "WHERE c.saisieLe between :minDate and :maxDate "
            + "GROUP BY cl.contact";

    @PersistenceContext(unitName = "comptoirs")
    private EntityManager em;

    public List unitesVenduesParCategorie() {
        Query query = em.createQuery(UNITS_SOLD, StatsResult.class);
        List results = query.getResultList();
        return results;
    }

    public List<StatsResult> chiffreAffaireCategorieDTO() {
        Query query = em.createQuery(CA_CATEGORIE_DTO, StatsResult.class);
        List<StatsResult> results = query.getResultList();
        return results;
    }

    public List<StatsResult> unitesVenduesParCategorieDTO() {
        Query query = em.createQuery(UNIT_SOLDS_DTO, StatsResult.class);
        List<StatsResult> results = query.getResultList();
        return results;
    }

    public List<StatsResult> produitsVendusPour(Integer codeCategorie) {
        Query query = em.createQuery(PRODUCTS_SOLDS_DTO, StatsResult.class);
        List<StatsResult> results = query.setParameter("test", codeCategorie).getResultList();
        return results;
    }

    public List<StatsResult> chiffreAffaireParPaysDTO() {
        Query query = em.createQuery(CA_PAYS_DTO, StatsResult.class);
        List<StatsResult> results = query.getResultList();
        return results;
    }

    public List chiffreAffaireClientDTO() {
        Query query = em.createQuery(CA_CLIENT_DTO, StatsResult.class);
        List results = query.getResultList();
        return results;
    }

    public HtmlDate datePlusRecenteCommande() {
        Date result = em.createQuery("select max(c.saisieLe) from Commande c", Date.class)
                .getSingleResult();
        return new HtmlDate(result);
    }

    public Date datePlusAncienneCommande() {
        Date result = em.createQuery("select min(c.saisieLe) from Commande c", Date.class)
                .getSingleResult();
        return new HtmlDate(result);
    }
        public List<StatsResult> chiffreAffairePaysDTO_DATE(Date minDate, Date maxDate) {
        return em.createQuery(CA_PAYS_DTO_DATE, StatsResult.class)
                .setParameter("minDate", minDate)
                .setParameter("maxDate", maxDate)
                .getResultList();

    }
        public List<StatsResult> chiffreAffaireClientDTO_DATE(Date minDate, Date maxDate) {
        return em.createQuery(CA_CLIENT_DTO_DATE, StatsResult.class)
                .setParameter("minDate", minDate)
                .setParameter("maxDate", maxDate)
                .getResultList();

    }

    public List<StatsResult> chiffreAffaireCategorieDTO_DATE(Date minDate, Date maxDate) {
        return em.createQuery(CA_CATEGORIE_DTO_DATE, StatsResult.class)
                .setParameter("minDate", minDate)
                .setParameter("maxDate", maxDate)
                .getResultList();

    }




}
