/**
 * taken from youtube: https://www.youtube.com/watch?v=Jl9OKQ92SJU
 */
package com.jah.springmvc;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

/**
 * Data Access Object for Alien class
 */
@Component
public class AlienDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	// get a List of all Aliens
	@Transactional
	public List<Alien> getAliens(){
		System.out.println("DAO getAliens called");
		
		Session session = sessionfactory.getCurrentSession();
		// the table name has to be same name as the class object, both identical
		// otherwise will get a table not mapped error:
		// QuerySyntaxException: Aliens is not mapped [from Aliens]
		List<Alien> aliens =    session.createQuery("from Alien", Alien.class).list();
		System.out.println(aliens.toString());
		
		return aliens;
	}

}
