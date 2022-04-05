package com.rag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	private int userId;
	@NotNull(message = "username should not be null  ") //add bean validation dependency in pom.xml..not working .. so added spring-boot-starter-validation
	private String userName;
	@Email(message = "invalid email ")
	private String email;
	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile no. ")
	private String mobile;	
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;
		
}