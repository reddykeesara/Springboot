package com.rag.security.authroles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository2 userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Userr user = userRepo.getUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find USer");
		}
		return new MyUserDetails(user);
	}

}
