package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect //포인트컷 + 어드바이스 연결
@Service //객체(인스턴스) 생성
public class BeforeAdvice {
	
	//포인트컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	//advice 동작시점 설정 + pointcut 지정
	@Before("allPointcut()") //메소드 호출 형식으로 사용
	public void beforeLog(JoinPoint jp) {
		System.out.println("[사전처리 - BeforeAdvice.beforeLog()]"
				+ "비즈니스 로직 수행 전 로그");
	}
}
