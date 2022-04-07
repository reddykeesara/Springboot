package com.rag.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rag.model.User;

//@RestController
//@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC = "rag_topic";

	//this method doesnt need kafka server location as it is installed in local machine
	//localhost:8080/kafka/pubish/hello  .. not json
	@GetMapping("publish/{message}")
	public String post(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC, message);
		return "Published successfully";
	}
	
	
	//
	 // @Autowired
	//KafkaTemplate<String, User> kafkaTemplate2;
	
	//localhost:8080/kafka/pubish/obj/rag ..non json
//	@GetMapping("publish/obj/{name}")
//	public String post2(@PathVariable("name") final String message) {
//		
//		kafkaTemplate2.send(TOPIC,  User.build(0, "Peter","Technology","", "", 120000, ""));
//		return "Published successfully";
//	}
//	
}
