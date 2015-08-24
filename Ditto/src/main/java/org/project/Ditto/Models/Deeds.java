package org.project.Ditto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deeds {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int d_id;
	
	private String d_deed;
	
	private String d_user_id;
	
	private String d_user_name;
	
	private int d_ditto_count;
	
	//getters and setters....

	public String getD_user_id() {
		return d_user_id;
	}

	public void setD_user_id(String d_user_id) {
		this.d_user_id = d_user_id;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_deed() {
		return d_deed;
	}

	public void setD_deed(String d_deed) {
		this.d_deed = d_deed;
	}

	public String getD_user_name() {
		return d_user_name;
	}

	public void setD_user_name(String d_user_name) {
		this.d_user_name = d_user_name;
	}

	public int getD_ditto_count() {
		return d_ditto_count;
	}

	public void setD_ditto_count(int d_ditto_count) {
		this.d_ditto_count = d_ditto_count;
	}
	
	
	
}
