package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

//@Controller : DispatcherServlet에서 인식할 수 있는 컨트롤러 객체 생성
@Controller
public class LoginController {
	
/*	@RequestMapping
		@RequestMapping : 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
		Command 객체 사용 : 파라미터로 전달되는 값을 Command 객체에 설정
		1. UserVO 타입 객체 생성
		2. UserVO 타입 객체에 전달받은 파라미터 값을 설정(파라미터명, 속성 일치 시)
		3. UserVO 타입 객체를 메소드의 파라미터 값으로 전달
 */
	@RequestMapping("/login.do") //요청명 annotation으로 작성하기
	public String login(UserVO vo, UserDAO userDAO) 
			//HttpServletRequest request, HttpServletResponse response : request,response 객체 -> spring에서 DI 하는 객체
			//UserVO vo, UserDAO userDAO -> Command 객체 
	
			throws ServletException, IOException {
		System.out.println(">>> 로그인 처리");
		System.out.println("vo : " + vo);
		
//		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		System.out.println("user : " + user);
		
		//3. 화면 네비게이션(화면전환, 화면이동)
		//로그인 성공 : 게시글 목록 보여주기
		//로그인 실패 : 로그인 화면으로 이동
		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			return "getBoardList.do"; 
		} else {
			System.out.println(">> 로그인 실패!!!");
			return "login.jsp";
		}
	}
		
}
