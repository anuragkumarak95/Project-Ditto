package org.project.Ditto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dto_Users {
	
	@Id
	private String u_name;

	private String u_pass;
	
	private String name;
		
	// getters and setters..


	public String getU_name() {
		return u_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
