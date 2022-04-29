package com.rag.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rag.model.User;
import com.rag.aspect.GeneralInterceptorAspect;
import com.rag.dto.UserRequest;
import com.rag.repo.UserRepository;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repo;

	public User saveUser(UserRequest userRequest) {
		log.info("in SaveUser " + userRequest);

		User user = User.build(0, userRequest.getUserName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repo.save(user);
		
	}

	public List<User> getAllUsers() {
		log.info("in getAllUsers ");
		return repo.findAll();
	}

	public User getUser(int id) throws UserNotFoundException {
		log.info("in getUser " + id);
		User user = repo.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("User not found");
		}

	}

}
