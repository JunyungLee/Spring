package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AroundAdvice {
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//핵심 메소드 실행 전 
		System.out.println("[Around BEFORE] 비즈니스 로직 실행 전 처리");
		
		Object returnObj = pjp.proceed(); //joinpoint method 실행 => 비즈니스 로직 실행 중..
		
		//핵심 메소드 실행 후 
		System.out.println("[Around AFTER] 비즈니스 로직 실행 후 처리");
		return returnObj;
	}
}
