package com.rag.security.jwt1;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository3 userRepository;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User2> user = userRepository.findByUserName(username);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
//
//        return user.map(MyUserDetails::new).get();

		return new User("foo","foo",new ArrayList<>());  ///prev code
	}

	
}
