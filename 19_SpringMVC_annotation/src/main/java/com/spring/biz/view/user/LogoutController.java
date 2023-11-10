package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout (HttpSession session)
			throws ServletException, IOException {
		System.out.println(">>> 로그아웃 처리");
		
		session.invalidate();
		
		return "login.jsp";
	}

}
