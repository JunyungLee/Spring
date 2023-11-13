package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	// getBoard
	//retrun 타입 : ModelAndView ---> String
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);

		BoardVO board = boardDAO.getBoard(vo);

//		mav.addObject("board", board);
//		mav.setViewName("getBoardDetail.jsp");
		
		model.addAttribute("board", board);
		
		return "getBoardDetail.jsp";
	}

	// getBoardList
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {

		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
//		List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

//		mav.addObject("boardList", boardList); // Model에 데이터 저장
//		mav.setViewName("getBoardList.jsp"); // View 명칭 저장
		model.addAttribute("boardList", boardList);

		return "getBoardList.jsp";
	}

	// insertBoard
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);

		boardDAO.insertBoard(vo);

		// 3.페이지 전환(목록페이지로 이동)
		return "getBoardList.do";
	}

	// updateBoard
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 수정");

		boardDAO.updateBoard(vo);

		return "getBoardList.do";
	}

	// deleteBoard
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 삭제");

		boardDAO.deleteBoard(vo);

		return "getBoardList.do";
	}
}
