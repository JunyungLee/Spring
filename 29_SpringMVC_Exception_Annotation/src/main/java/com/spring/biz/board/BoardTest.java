package com.spring.biz.board;

import java.util.List;
public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트2");
		vo.setWriter("홍길동2");
		vo.setContent("테스트2-내용");
		
		/*
		 * BoardDAO dao = new BoardDAO(); dao.insertBoard(vo);
		 * 
		 * vo.setSeq(2); BoardVO board = dao.getBoard(vo); System.out.println("board : "
		 * + board);
		 * 
		 * //update 테스트 vo.setSeq(3); vo.setTitle("테스트2-수정");
		 * vo.setContent("테스트2-내용수정"); dao.updateBoard(vo);
		 * 
		 * //delete 테스트 vo.setSeq(5); dao.deleteBoard(vo);
		 * 
		 * System.out.println("================="); List<BoardVO> list =
		 * dao.getBoardList(); for (BoardVO bvo : list) { System.out.println(bvo); }
		 * 
		 */
	}

}
