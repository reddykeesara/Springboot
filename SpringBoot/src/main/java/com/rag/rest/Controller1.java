package com.rag.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

	//http://localhost:8080/req?name=rag
	@RequestMapping("/req")
	public String home(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("/req2")
	public String home(String name, HttpSession session) { //name matches with param..http://localhost:8080/req2?name=ragggj
		
		session.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("/req3")
	public String home2(@RequestParam("name")String myName, HttpSession session) {	
		session.setAttribute("name", myName);
		return "home";
	}
	
	@RequestMapping("/req4")
	public ModelAndView home11(@RequestParam("name")String myName) {
		System.out.println(" param "+myName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home"); //set prefix suffix in app.props .. home.jsp in webapp/pages
		return mv;              //for jsp downloads .. add tomcat embed jasper dependency
	}
}
