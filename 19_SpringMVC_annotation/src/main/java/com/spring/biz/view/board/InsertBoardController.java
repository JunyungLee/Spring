package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping("/insertBoard.do")
	public String insertBoard (BoardVO vo, BoardDAO boardDAO)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);

		boardDAO.insertBoard(vo);
		
		//3.페이지 전환(목록페이지로 이동)
		return "getBoardList.do";
	}
	
}
