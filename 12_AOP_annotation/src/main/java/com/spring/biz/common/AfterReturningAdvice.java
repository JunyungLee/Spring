package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterReturningAdvice {
	// 포인트 컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void getPointcut() {
	}

	// 어드바이스
	@AfterReturning(pointcut = "allPointcut()", returning = "returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		System.out.println("[후처리 - AfterReturningAdvice.afterReturnLog]" + "정상실행 후 로그 - " + returnObj);
	}

}
