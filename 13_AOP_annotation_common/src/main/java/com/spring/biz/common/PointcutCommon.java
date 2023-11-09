package com.spring.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {
	
	//포인트 컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void getPointcut() {}
}
