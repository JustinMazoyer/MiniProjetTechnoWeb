/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.entity.Client;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Justin
 */
@SessionScoped
@Named("player")
public class ClientInfo implements Serializable {
	
	private String playerName = null;
	
	public void login(String name) {
		this.playerName = name;
	}
        	public String getCode() {
		return playerName;
	}
}

