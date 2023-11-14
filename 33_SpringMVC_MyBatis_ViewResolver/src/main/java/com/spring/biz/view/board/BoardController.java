package com.spring.biz.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

/*
@SessionAttributes : 같은 컨트롤러에서 모델객체 공유해서 사용(session)
   	단, 현재(동일) 컨트롤러에서만 사용 가능
   	사용완료되면 SessionStatus 객체의 setComplete() 메소드 사용해서 해제
@SessionAttribute : HttpSession 에 데이터 저장 및 읽기
 */


@Controller
@SessionAttributes("board") 
@RequestMapping("/board")
public class BoardController {
//	@Autowired //기본 생성자 사용
	private BoardService boardService;  
	//Controller에 boardService 주입 => boardService 사용 : boardDAO 주입 받을 필요 없음
	
	public BoardController() {
		System.out.println(">>> BoardController() 객체 생성");
	}
	
	@Autowired //이 생성자 사용
	public BoardController(BoardService boardService) {
		System.out.println(">>> BoardController(boardService) 객체 생성");
		System.out.println("::: BoardService boardService : " + boardService);
		this.boardService = boardService;
	}
	
	// 메소드 선언부에 선언된 @ModelAttribute 는 리턴된 데이터를 VIEW에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행
	// 뷰에 전달해준 명칭(예: conditionMap) 사용 
	@ModelAttribute("conditionMap") //메소드 선언부에 ModelAttribute 선언
	public Map<String,String> searchConditionMap(){
		System.out.println("===> Map searchConditionMap() 실행");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	// getBoard
	//return 타입 : ModelAndView ---> String
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);

		BoardVO board = boardService.getBoard(vo);
		System.out.println("board : " + board);

		model.addAttribute("board", board); //Model 객체 사용 View로 데이터 전달
		
		return "getBoardDetail.jsp";
	}

	// getBoardList
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
//		List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList(vo);

		model.addAttribute("boardList", boardList);

		return "getBoardList.jsp";
	}

	// insertBoard
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);

		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println(">> uploadFile : " + uploadFile);
		
		if (uploadFile == null) {
			System.out.println(":: uploadFile 파라미터가 전달되지 않은 경우");
		} else if (uploadFile.isEmpty()) {
			System.out.println(":: 전달받은 파일이 없는 경우");
		} else { //파일 업로드가 된 경우
			System.out.println(">> 파일 업로드 됨  : " + "uploadFIle.isEmpty() : " + uploadFile.isEmpty());
			//원본파일명 구하기 
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + fileName);
			String savedFilename = UUID.randomUUID().toString(); //중복되지 않은 임의의 값 생성 (universally unique identifier)
			System.out.println("저장파일명 : " + savedFilename);
			
			//물리적 파일 복사
//			uploadFile.transferTo(new File("C:/MyStudy/temp/" + savedFilename));
			String destPathFIle = "C:/MyStudy/temp/" + savedFilename;
			uploadFile.transferTo(new File(destPathFIle));
		}
		
		boardService.insertBoard(vo);

		// 3.페이지 전환(목록페이지로 이동)
		return "getBoardList.do";
	}

	// updateBoard
	// @ModelAttribute("board") : @SessionAttributes 설정으로 존재하는 "board" 데이터 사용
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) { //session에 있는 board 사용 -> BoardVO vo에 저장
		System.out.println(">>> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardService.updateBoard(vo);

		return "getBoardList.do";
	}

	// deleteBoard
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, SessionStatus sessionStatus) {
		System.out.println(">>> 게시글 삭제");

		boardService.deleteBoard(vo);
		sessionStatus.setComplete();
		
		return "getBoardList.do";
	}
}
