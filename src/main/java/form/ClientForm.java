/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.mvc.binding.MvcBinding;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 *
 * @author Justin
 */
public class ClientForm implements Serializable {

    private static final long serialVersionUID = -3523783484400524581L;
    @MvcBinding
    @FormParam("code")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String Code;

    @MvcBinding
    @FormParam("societe")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String Societe;

    @MvcBinding
    @FormParam("contact")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String contact;

    @MvcBinding
    @FormParam("fonction")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String fonction;

    @MvcBinding
    @FormParam("adresse")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String adresse;

    @MvcBinding
    @FormParam("ville")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String ville;

    @MvcBinding
    @FormParam("region")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String region;

    @MvcBinding
    @FormParam("codePostal")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String codePostal;

    @MvcBinding
    @FormParam("pays")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String pays;

    @MvcBinding
    @FormParam("telephone")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String telephone;

    @MvcBinding
    @FormParam("fax")
    //@NotEmpty
    @Size(min = 1, max = 255)
    private String fax;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getSociete() {
        return Societe;
    }

    public void setSociete(String Societe) {
        this.Societe = Societe;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
