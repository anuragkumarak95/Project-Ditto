package org.project.Ditto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dto_Users {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int u_id;
	
	private String u_name;
	
	private String u_pass;

	
	// getters and setters..
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	
	
	
}
