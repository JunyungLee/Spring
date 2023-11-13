package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동전 --------");
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서)
		GenericXmlApplicationContext container
				= new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("--- 스프링 컨테이너 구동후 --------");
		
		//2. 스프링 컨테이너 사용
		BoardService boardService = (BoardService) container.getBean("boardService");
		System.out.println("boardService : " + boardService);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목-spring");
		vo.setWriter("홍길동-spring");
		vo.setContent("내용-spring");
		
		boardService.insertBoard(vo);
		
		List<BoardVO> list = boardService.getBoardList();
		for (BoardVO board : list) {
			System.out.println(board);
		}
		
		System.out.println("--- 스프링 컨테이너 종료처리 --------");
		//3. 스프링 컨테이너 종료
		container.close();

	}

}
