/**
 * Alien Model object
 */
package com.jah.springmvc;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Bean, Alien
 */
@Entity
public class Alien {

	@Id
	private int aid; // ** alien ID, has to be same name as in the table in the database **
	private String name;
	
	// default Constructor
	public Alien() {
		aid = 0;
		name = "Alien";
	}
	
	/* --- Get and Set Methods ---  */
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + name + "]";
	}
	
	
	
}
