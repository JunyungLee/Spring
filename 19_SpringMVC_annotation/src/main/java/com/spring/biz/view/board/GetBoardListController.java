package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do") //요청 여러개면 배열에 담아 전달해주기
	public ModelAndView getBoardList (BoardDAO boardDAO, ModelAndView mav)
			throws ServletException, IOException {
		
		System.out.println(">>> 게시글 전체 목록 보여주기");
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		mav.addObject("boardList", boardList); //Model에 데이터 저장 
		mav.setViewName("getBoardList.jsp"); //View 명칭 저장
		//데이터도 저장하고 view 명칭도 저장해야 되기 때문에 -> ModelAndView 사용하기
		
		return mav;
	}

}
