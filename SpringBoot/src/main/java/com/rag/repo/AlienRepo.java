package com.rag.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rag.model.Alien;


@Component("repo1")
public interface AlienRepo extends CrudRepository<Alien, Integer> {


	
	
	
}
 