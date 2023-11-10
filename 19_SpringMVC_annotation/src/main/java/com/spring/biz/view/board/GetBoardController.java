package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO) throws ServletException, IOException {
		System.out.println(">>> 게시글 상세 보여주기");

		BoardVO board = boardDAO.getBoard(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoardDetail.jsp");

		return mav;
	}

}
