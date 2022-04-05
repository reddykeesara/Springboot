package com.rag.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rag.aspect.GeneralInterceptorAspect;
import com.rag.dto.UserRequest;
import com.rag.model.User;
import com.rag.service.UserNotFoundException;
import com.rag.service.UserService;


/*this class takes post and get request from postman
and validates using @valid in dto userRequest.java  and does exception handling
for this we created AppExcepHandler.java 

Post in postman
{
    "userName":"Ragoo2",
    "email":"rag@gmail.com",
    "mobile":"0000000000",
    "gender":"M",
    "age":34,
    "nationality":"indian"
}

localhost:8080/users/1
localhost:8080/users/fetchAll
*/
@RestController
@RequestMapping("/users")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	ResponseEntity<User> saveUser( @RequestBody  @Valid  UserRequest  userRequest){
		
		log.info("in saveuser "+userRequest);
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);		
	} 
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers(){
		log.info("in getAllUsers ");
		return ResponseEntity.ok(userService.getAllUsers());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		log.info("in getUser "+id);
		return ResponseEntity.ok(userService.getUser(id));
	}
}
