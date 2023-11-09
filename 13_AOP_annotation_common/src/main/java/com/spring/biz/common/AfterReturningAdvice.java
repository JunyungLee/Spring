package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterReturningAdvice {
	//어드바이스
	@AfterReturning(pointcut = "PointcutCommon.allPointcut()",returning = "returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		System.out.println("[후처리 - AfterReturningAdvice.afterReturnLog]"
						+"정상실행 후 로그 - " + returnObj);
	}
	
}
