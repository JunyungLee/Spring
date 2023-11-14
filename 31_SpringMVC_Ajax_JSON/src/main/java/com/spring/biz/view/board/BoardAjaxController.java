package com.spring.biz.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Controller
@RestController //클래스 내의 요청처리 결과가 모두 @ResponseBody 처리됨 -> @ResponseBody 할 필요 없다
public class BoardAjaxController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getJsonBoardList.do")
//	@ResponseBody //response 응답 객체의 몸체(body)에 데이터 전달 => response.writevalue~~() 와 같은 작업 annotation으로 해결
	public List<BoardVO> getAjaxBoardList(BoardVO vo) {
		System.out.println(">> getAjaxBoardList()실행");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println(">boardList : " + boardList);
		return boardList;
	}
	
	@RequestMapping("/getJsonBoard.do")
//	@ResponseBody
	public BoardVO getAjaxBoard(@RequestBody BoardVO vo) { //@RequestBody post 방식 전달데이터 처리
		System.out.println(">> getAjaxBoard() 실행");
		System.out.println(">> getAjaxBoadr() vo : " + vo);
		
		BoardVO board = boardService.getBoard(vo);
		System.out.println("board : " + board);
		
		return board;
	}
}
