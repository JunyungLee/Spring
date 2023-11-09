package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AfterThrowingAdvice {
	// 포인트 컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void getPointcut() {
	}

	// exceptObj : 스프링 설정 파일에 설정 추가
	@AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		System.out.println("[후처리 - AfterThrowingAdvice.exceptionLog] " + "예외 발생 - " + exceptObj);
	}
}
