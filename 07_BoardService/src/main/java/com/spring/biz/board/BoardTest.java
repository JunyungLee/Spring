package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		//insert
		BoardVO vo = new BoardVO();
	//	vo.setTitle("테스트2");
	//	vo.setWriter("홍길동2");
	//	vo.setContent("테스트2-내용");
		
		BoardDAO dao = new BoardDAO();
	//	dao.insertBoard(vo);
		
		//update
	//	vo = new BoardVO();
	//	vo.setTitle("제목");
	//	vo.setContent("내용");
	//	dao = new BoardDAO();
	//	dao.updateBoard(vo);
		
		//delete 
		vo = new BoardVO();
		vo.setSeq(3);
		dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		//select 목록
		List<BoardVO> boardList = dao.getBoardList(vo);
		System.out.println("> boardList : " + boardList );
		
		
		//select 1개 
		vo.setSeq(1);
		BoardVO board = dao.getBoard(vo);
		System.out.println("> board : " + board);

		
		
	}

}
