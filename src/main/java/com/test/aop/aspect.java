package com.test.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aspect {
	
	private static final Logger logger = LogManager.getLogger(aspect.class);
	
	@Around("@annotation(log)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
      
		logger.info("start - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());
      
		Object result = joinPoint.proceed();
      
      logger.info("finished - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());

		return result;
	}
	
	
}
