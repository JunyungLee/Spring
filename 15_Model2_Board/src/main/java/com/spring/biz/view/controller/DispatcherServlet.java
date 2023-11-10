package com.spring.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">> DispatcherServlet process() : *.do 요청처리~~");
		
		//1. 클라이언트에서 어떤 작업을 요청했는지 확인하기
		String uri = request.getRequestURI(); //  /biz/login.do
		System.out.println("uri : " + uri);
		String path = uri.substring(uri.lastIndexOf('/'));
		System.out.println("path : " + path);
		
		//2. 클라이언트 요청형태에 따른 작업 처리
		if ("/login.do".equals(path)) {
			System.out.println(">>> 로그인 처리");
			//1. 사용자 전달한 데이터(정보) 확인(추출)
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB연동작업(id, password 유무확인
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션(화면전환, 화면이동)
			//로그인 성공 : 게시글 목록 보여주기
			//로그인 실패 : 로그인 화면으로 이동
			if (user != null) {
				System.out.println(">> 로그인 성공!!!");
				response.sendRedirect("getBoardList.do");
			} else {
				System.out.println(">> 로그인 실패!!!");
				response.sendRedirect("login.jsp");
			}
		}
		if ("/logout.do".equals(path)) {
			System.out.println(">>> 로그아웃 처리");
			//1.세션 초기화 (세션 객체 무효화)
			request.getSession().invalidate();
			//2.화면 네비게이션(화면이동)
			response.sendRedirect("login.jsp");
		}
		if ("/getBoardList.do".equals(path)) {
			System.out.println(">>> 게시글 전체 목록 보여주기");
			//1. 게시글 목록 조회(SELECT)
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList();
			
			//2. 검색 결과를 세션에 저장하고
			request.getSession().setAttribute("boardList", boardList);
			
			//3. 목록 화면으로 이동
			response.sendRedirect("getBoardList.jsp");
		}
		if ("/getBoard.do".equals(path)) {
			System.out.println(">>> 게시글 상세 보여주기");
			
			//1. 전달받은 데이터 확인(추출)
			int seq = (Integer.parseInt(request.getParameter("seq")));
			
			//2-1.  DB 연동(게시글 1개 조회)
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//2-2.검색결과를 세션에 저장(뷰에서 사용 가능하게)
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//3. 페이지 전환(상세페이지로 이동)
			response.sendRedirect("getBoardDetail.jsp");
		}
		if ("/insertBoard.do".equals(path)) {
			System.out.println(">>> 게시글 입력");
			//1.전달받은 파라미터 값 처리
			String title =request.getParameter("title");
			String writer =request.getParameter("writer");
			String content =request.getParameter("content");
			
			//2.DB 연동 작업(입력) 
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			//3.페이지 전환(목록페이지로 이동)
			response.sendRedirect("getBoardList.do");
		}
		if ("/updateBoard.do".equals(path)) {
			System.out.println(">>> 게시글 수정");
			
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}
		if ("/deleteBoard.do".equals(path)) {
			System.out.println(">>> 게시글 삭제");
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}
		
	}

}
