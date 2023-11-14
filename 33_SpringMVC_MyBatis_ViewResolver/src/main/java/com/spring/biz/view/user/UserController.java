package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
//	@Autowired 
	private UserService userService;
	
	public UserController() {
		System.out.println(">> UserController() 객체 생성");
	}
	
	@Autowired
	public UserController(UserService userService) {
		System.out.println(">> UserController(userService) 객체 생성");
		this.userService = userService;
	}
	
	//requestMapping : get, post 둘다 처리 가능
	@RequestMapping(value = "/login.do",method = RequestMethod.POST) //POST 방식 요청이 들어왔을 때만 처리 
//	@PostMapping("/login.do") //4.3버전 부터 사용가능
	public String login(UserVO vo) {
		System.out.println(">>> 로그인 처리");
		System.out.println("vo : " + vo);

		//일부로 예외 발생 시키기
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}
		
		UserVO user = userService.getUser(vo);
		System.out.println("user : " + user);

		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			return "getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패!!!");
			return "login.jsp";
		}
	}
	
/*	@ModelAttribute : 모델(Model)의 속성값으로 저장(속성명 별도 지정)
	별도 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭 사용
	@ModelAttribute UserVO ---> 속성명 userVO 명칭 사용
	@ModelAttribute("user") UserVO ---> 속성명 user 사용
*/	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET) //GET 방식 요청이 들어왔을 떄만 처리 
//	@GetMapping("/login.do") //위와 동일
	
	public String loginView(@ModelAttribute("user") UserVO vo) { //UserVO 에 Model명 부여 
		System.out.println(">> login 화면으로 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp"; //db 연동작업 안하고 단순히 페이지만 이동
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");

		session.invalidate();

		return "login.jsp";
	}
}
