package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 삭제");
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
