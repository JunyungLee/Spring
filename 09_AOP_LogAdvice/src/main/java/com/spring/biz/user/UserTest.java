package com.spring.biz.user;

import com.spring.biz.user.impl.UserDAO;

public class UserTest {
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		UserDAO dao = new UserDAO();
		
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = dao.getUser(vo);
		System.out.println("> user : " + user);
	}
}
