/**
 * from youtube https://www.youtube.com/watch?v=Jl9OKQ92SJU
 */
package com.jah.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jah.springmvc.Alien;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;

/**
 * The Controller servlet in the Spring Boot MVC
 */
@Controller
public class HomeController {
	
	@Autowired
	private AlienDAO dao;
	
	
	// ModelAttribute is called before any Spring
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("username", "Scooby");
		// used in the jsp page AlienResults as Welcome Back ${username}
	}

	
	@RequestMapping("/")
	public String home() {
		System.out.println("home page requested");
		return "index";
	}
	
	
	// add an alien, get data from client
	@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid") int aid, @RequestParam("name") String name, Model m) {
		System.out.println("Add Alien called...");
		
		Alien al = new Alien();
		al.setAid(aid);
		al.setName(name);
		System.out.println("Saving Alien: " + al.toString());
		dao.addAlien(al);
		m.addAttribute("result", dao.getAliens());
		//m.addAttribute("alien", al);
		
		return "showAliens";
		
	}
	
	
	// get Aliens listing
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		System.out.println("getAliens called\n");
		
		m.addAttribute("result", dao.getAliens());
		
		return "showAliens";
		
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam("aid") String aid, Model m) {
		System.out.println("searching for alien: " + aid );
		
		if(aid.isBlank()) {
			System.out.println("aid is blank");
		}else {
			int axid = Integer.parseInt(aid);	
			m.addAttribute("result", dao.getAlien(axid));
		}
		
		
		
		//m.addAttribute("result", dao.getAliens());
		
		return "showAliens";
	}
	
	
	
	// -- Calculation add to numbers
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		// using MVC pattern here:
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int total = num1+num2;
		
		mv.addObject("total", total);
		
		return mv;
	}
	
	// alternate way to handle the customer data using Spring
//	public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session)
//	{
//		int total = num1+num2;
//		
//		session.setAttribute("total", total);
//		
//		return "result.jsp";
//	}
	// this block works, using HttpServletRequest
//	public String add(HttpServletRequest req) {
//		
//		int num1 = Integer.parseInt( req.getParameter("num1"));
//		int num2 = Integer.parseInt( req.getParameter("num2"));
//		int total = num1+num2;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("total", total);
//		return "result.jsp";
//	}
}
