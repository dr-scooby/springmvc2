/**
 * Alien Model object
 */
package com.jah.springmvc;

/**
 * The Bean, Alien
 */
public class Alien {

	private int aid; // alien ID
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
