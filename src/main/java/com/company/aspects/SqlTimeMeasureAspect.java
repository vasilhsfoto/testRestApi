package com.company.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*
 * Defining an Aspect (advice) using Aspect J annotation avoiding all the configuration files.
 * Although this will be treated by Spring as an Advice and it will be used for creating the proxies classes
 * It still a valid POJO class; that we can use as Spring managed bean. In fact, the proxy doesn't work if you 
 * don't define it as a Service.
 * 
 * Here Spring AOP implementation is still used. Don't get confused with the usage of Aspect J's annotations
 * for defining Aspects, etc.... Just Spring uses this annotation instead of defining its own one.
 * For instance the pointcut expression is AspectJ's language.
 * 
 * We don't use AspectJ; we still use Spring AOP proxy implementation.
 * 
 */
@Aspect
@Service("sqlTimeMeasureAspect")
public class SqlTimeMeasureAspect {
	
	/**
	 * define a pointcut using AspectJ language. This means that Spring AOP proxy will be contructed
	 * for all the methods annotated with MonitorSqlOperations. This is our own customed defined annotation.
	 * This is our basic PointCut with name sqlTimeExecution(). 
	 */
	@Pointcut("execution(@com.company.aspects.MonitorSqlOperations * *(..))")
	public void sqlTimeExecution() {}
	
	@Around("sqlTimeExecution()")
	public void measureAround(ProceedingJoinPoint jointPoint) throws Throwable {
		System.out.println("before aspect is being executed");
		
		//aspect gives control to the production code
		jointPoint.proceed();
		
		System.out.println("after aspect is being executed");
	}
	
	//@Before("sqlTimeExecution()")
	public void measureBefore(JoinPoint joinPoint) {
		System.out.println("before aspect is being executed");
	}
	
	//@After("sqlTimeExecution()")
	public void measureAfter(JoinPoint joinPoint) {
		System.out.println("after aspect is being executed");
	}
}
