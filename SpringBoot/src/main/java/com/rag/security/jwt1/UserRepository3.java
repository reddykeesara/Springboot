package com.rag.security.jwt1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rag.security.authroles.Userr;

public interface UserRepository3 extends JpaRepository<User2, Integer> {
	Optional<User2> findByUserName(String userName);

}