/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import form.ClientForm;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Nicolas
 */
@Controller
@Path("mdification")
@View("mdification.jsp")

public class ModificationController {

    @Inject
    ClientFacade dao;

    @Inject
    BindingResult formValidationErrors;

    @Inject
    Models models;
    @Inject
    private ClientInfo player;

    @GET
    public void show(@QueryParam("code") String codeClient) {
        codeClient = player.getCode();
        Client c = dao.find(codeClient);
        models.put("client", c);
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public void edit(@Valid @BeanParam ClientForm formData) {
        Client c = dao.find(formData.getCode());
        c.setSociete(formData.getSociete());
        c.setContact(formData.getContact());
        c.setFonction(formData.getFonction());
        c.setAdresse(formData.getAdresse());
        c.setVille(formData.getVille());
        c.setRegion(formData.getRegion());
        c.setCodePostal(formData.getCodePostal());
        c.setPays(formData.getPays());
        c.setTelephone(formData.getTelephone());
        c.setFax(formData.getFax());
        dao.edit(c);
        models.put("client", c);
    }
}
