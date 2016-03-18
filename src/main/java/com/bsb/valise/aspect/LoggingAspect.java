package com.bsb.valise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * any bean defined in your application context with a class that is an @AspectJ
 * aspect (has the @Aspect annotation) will be automatically detected by Spring
 * and used to configure Spring AOP
 * 
 * @author deepesh
 *
 */
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* com.bsb.valise.dto.CustomerBo.addCustomer(..))")
	public void loggBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@Before("execution(* com.bsb.valise.dto.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.bsb.valise.dto.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
}
