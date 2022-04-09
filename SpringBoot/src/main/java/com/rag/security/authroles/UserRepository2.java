package com.rag.security.authroles;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository2 extends CrudRepository<Userr, Integer>{

    @Query("SELECT u FROM Userr u WHERE u.userName = :userName")
    public Userr getUserByUserName(@Param("userName")String username);
}
