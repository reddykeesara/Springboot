package com.rag.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rag.aspect.CustomAnnot;
import com.rag.model.Alien;
import com.rag.service.AlienService;


@Controller
//@RestController
public class AlienController {

	//Logger logger = LoggerFactory.getLogger(AlienController.class);



	@Autowired
	AlienService alienService;

	@RequestMapping({"/hello"})
	public String hello() {
		return "hello world";
	}
	
//	@RequestMapping({"/home"})
//	public String home() {
//		return "hello world";
//	}
	
	@RequestMapping("/fw")
	public ModelAndView home11(@RequestParam("name")String myName) {
		//logger.info(" param "+myName);
		//logger.debug(" param "+myName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home"); //set prefix suffix in app.props .. home.jsp in webapp/pages
		return mv;              //for jsp downloads .. add tomcat embed jasper dependency
	}
	
	
	@RequestMapping("/fwobj")   
	//http://localhost:8080/fwobj?aid=111&aname=ragg&tech=java
	public ModelAndView homeObj(Alien alien) {
		System.out.println(" obj param "+alien);
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",alien);
		mv.setViewName("home"); 
		return mv;             
	}
	
	@RequestMapping("/fw2")
	
	public ModelAndView home12( ) {
		Alien	alien = new Alien();
		alien.setAid(123);
		alien.setAname("abcD");
		alien.setTech("java");
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",alien);
		mv.setViewName("home");
		return mv;
	}


	@CustomAnnot
	@RequestMapping("/al")
	public String alienHome() {
		
		return "alien";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienService.save(alien);
		return "alien";
	}

//	@PostMapping("/alien")
//	public Alien addAlien(@RequestBody Alien alien) {
//		alienService.save(alien);
//		return alien;
//	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		//logger.info(" param "+aid);
		//logger.debug(" param "+aid);
		//logger.error(" param "+aid);
		//logger.trace(" param "+aid);
		//logger.warn(" param "+aid);
		ModelAndView mv = new ModelAndView("showAlien");
		Alien alien = alienService.findById(aid).orElse(new Alien());
		System.out.println(alien);
	    mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/getAlienByTech")
	@ResponseBody
	public ModelAndView getAlienByTech(@RequestParam String tech) {
		System.out.println("inside getalienbytec ");
		ModelAndView mv = new ModelAndView("showAlien"); // List<Alien> alien = repo.findByTech(tech);
		List<Alien> alien = alienService.findByTechSorted(tech);
		System.out.println(alien);
		mv.addObject(alien);
		return mv;
	}
//
//	@RequestMapping("/getAlienGt101")
//	public ModelAndView getAlienGt101(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		List<Alien> alien = alienService.findByAidGreaterThan(aid);
//		System.out.println(alien);
//
//		mv.addObject(alien.toString());
//		return mv;
//	}
	 

	
}
