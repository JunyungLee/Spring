package com.spring.biz.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[후처리 - AfterThrowingAdvice.exceptionLog]"
				 			+ "비즈니스 로직 수행 중 예외 발생 시 로그");
	}
}
