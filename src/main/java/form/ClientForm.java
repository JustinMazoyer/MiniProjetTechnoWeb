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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
