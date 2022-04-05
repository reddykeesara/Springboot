package com.rag.aspect;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rag.model.Alien;
import com.rag.mq.Employee;
import com.rag.rest.AlienController;

import lombok.extern.slf4j.Slf4j;

//@Aspect
//@Slf4j
//@Component
public class GeneralInterceptorAspect {
	Logger log = LoggerFactory.getLogger(GeneralInterceptorAspect.class);

	@Pointcut("execution(* com.rag.rest.*.*(..))") // first * return type 2nd class, 3rd method name .. args
//	@Pointcut("within(com.rag.rest.*)")
//	@Pointcut("this(com.rag.service.AlienService)")	
//	@Pointcut("@annotation(com.rag.aspect.CustomAnnot)")

	public void loggingPointCut() {

	}

	@Before("loggingPointCut()")
	public void before(JoinPoint joinPoint) {
		log.info("before method invoked " + joinPoint.getSignature());
		
	}

	@After("loggingPointCut()")
	public void after(JoinPoint joinPoint) {
		log.info("after method invoked " + joinPoint.getSignature());
	}

//	@AfterReturning(value = "execution(* com.rag.*.*(..))", returning = "alien")
//	public void after(JoinPoint joinpoint, Optional<Alien> alien) {
//		log.info("after method invoked" + alien);
//	}
//
//	@AfterThrowing(value = "execution(* com.rag.*.*(..))", throwing = "e")
//	public void after(JoinPoint joinpoint, Exception e) {
//		log.info("after method invoked" + e.getMessage());
//	}
//
	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("before method invoked  " + joinPoint.getSignature());
		Object object = joinPoint.proceed();
		if (object instanceof Employee) {
			log.info("after method invoked.." + joinPoint.getArgs()[0]);

		} else if (object instanceof Alien) {
			log.info("after method invoked.." + joinPoint.getArgs()[0]);
		}
		return object;
	}
}
