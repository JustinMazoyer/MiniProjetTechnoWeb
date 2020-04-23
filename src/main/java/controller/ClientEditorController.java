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

import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

@Controller
@Path("clientEditor")
@View("clientEditor.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class ClientEditorController {

    @Inject
    ClientFacade dao;

    @Inject
    BindingResult formValidationErrors;

    @Inject
    Models models;

    @Inject // Les infos du joueur, Session scoped
    private ClientInfo player;

    @GET
    public void show() {
        models.put("clients", dao.findAll());
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public String login(@Valid @BeanParam ClientForm formData) {
        if (!formValidationErrors.isFailed()) {
            try {
                if ((formData.getContact().equals("Admin")) && ((formData.getCode().equals("Admin")))) {

                    return "redirect:../Admin.html";
                }
                Client codeClient = dao.find(formData.getCode());
                if (codeClient.getContact().equals(formData.getContact())) {
                    player.login(formData.getCode());
                    return "redirect:../client.html";
                } else {
                    models.put("databaseErrorMessage", "Le contact est invalide");
                }
            } catch (Exception e) {
                models.put("databaseErrorMessage", "Le code est invalide");
            }
        }
        models.put("validationErrors", formValidationErrors);
        return null;

    }
}
