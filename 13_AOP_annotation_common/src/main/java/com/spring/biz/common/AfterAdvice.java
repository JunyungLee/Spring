package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//(실습) AOP 관련 어노테이션 설정
@Aspect
@Service
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog() {
		System.out.println("[후처리 - AfterAdvice.afterLog]"
						+ "비즈니스 로직 수행 후 로그(언제나, 무조건)");	
	}
}
