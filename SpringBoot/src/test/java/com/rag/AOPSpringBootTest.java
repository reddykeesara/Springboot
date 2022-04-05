package com.rag;

	
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rag.service.AlienService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPSpringBootTest 
{
  @Autowired
  private AlienService service;
   
  @Test
  public void testGetDomainObjectById() 
  {
    service.findByAidGreaterThan(3);
  }
}