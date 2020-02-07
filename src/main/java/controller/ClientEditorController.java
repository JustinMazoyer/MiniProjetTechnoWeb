package controller;

import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Client;
import form.ClientForm;

import java.util.List;
import javax.ejb.EJBException;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

@Controller
@Path("clientEditor")
@View("clientEditor.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class ClientEditorController {

    private EntityManagerFactory emf = null;
    @Inject
    ClientFacade dao;

    @Inject
    Client client;

    @Inject
    BindingResult formValidationErrors;

    @Inject
    Models models;

    @GET
    public void show() {
        models.put("clients", dao.findAll());
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public void create(@Valid @BeanParam ClientForm formData) {
        if (!formValidationErrors.isFailed()) {
            try {
                final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("comptoirs");
                EntityManager em = emFactory.createEntityManager();
                Client codeClient = em.createNamedQuery("Client.findByCode", Client.class)
                        .setParameter("code", formData.getCode()).getSingleResult();
                Client contactClient = em.createNamedQuery("Client.findByContact", Client.class)
                        .setParameter("contact", formData.getContact()).getSingleResult();
                if (codeClient.equals(contactClient)) {
                    models.put("Validé", formData.getContact()+"est connecté(e)");                 
                }else{
                     models.put("databaseErrorMessage", "Veuillez ressayer"); 
                }

            } catch (EJBException e) {

            }

            models.put("validationErrors", formValidationErrors);
            models.put("clients", dao.findAll());
        }
    }
}
