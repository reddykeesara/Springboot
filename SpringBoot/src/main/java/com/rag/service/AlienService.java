package com.rag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rag.model.Alien;
import com.rag.repo.AlienRepo;
import com.rag.repo.AlienRepo2;

@Service
public class AlienService {

	@Autowired
	@Qualifier("repo1")
	AlienRepo repo;
	
	
	@Autowired
	@Qualifier("repo2")
	AlienRepo2 repo2;


	public void save(Alien alien) {
		repo.save(alien);
		
	}


	public Optional<Alien> findById(int aid) {
		Optional<Alien> alien = repo2.findById(aid);
		return alien;
	}


	public List<Alien> findByTechSorted(String tech) {
		 List<Alien> aliens = repo2.findByTechSorted(tech);
		return aliens;
	}


	public List<Alien> findByAidGreaterThan(int i) {
		List<Alien> aliens = repo2.findByAidGreaterThan(i);
		return aliens;
	}
	
}
