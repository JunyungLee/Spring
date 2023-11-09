package com.spring.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		System.out.println("-- Spring Container 구동 전");
		
		// 스프링 컨테이너 구동
		GenericXmlApplicationContext container 
			= new GenericXmlApplicationContext("applicationContext_after-returning.xml");
		System.out.println(">> Spring container 구동 후");
		
		// 스프링 컨테이너 사용
		UserService userService = (UserService) container.getBean("userService");
		System.out.println(">> userService : " + userService);
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		UserVO user = userService.getUser(vo);
		System.out.println("user : " + user);
		//스프링 컨테이너 종료
		container.close();
	}

}
