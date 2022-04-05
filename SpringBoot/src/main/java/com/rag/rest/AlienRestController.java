package com.rag.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rag.model.Alien;
import com.rag.repo.AlienRepo2;

@RestController
public class AlienRestController {

	@Autowired
	AlienRepo2 repo;

	
	// using rest api
		@RequestMapping("/alien")
		//@ResponseBody
		public String getAlien() {
			
			return repo.findAll().toString();
		}
		 
	// @RequestMapping("/aliens")
	@GetMapping("/aliens")
	// @ResponseBody // we are using @restController
	public List<Alien> getAliens() {
system.out.println("in getAliens")
		return repo.findAll();
	}

	// this method only produces xml above method accepts both
	@RequestMapping(path = "/aliens2", produces = { "application/xml" })
	@ResponseBody
	public List<Alien> getAliens2() {

		return repo.findAll();
	}

	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {

		// return repo.findById(aid).toString();
		return repo.findById(aid);
	}

}
