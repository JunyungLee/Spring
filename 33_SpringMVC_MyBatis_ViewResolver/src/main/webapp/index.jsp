<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script> 
<script>
	function getJsonBoardList(){
		alert("getJsonBoardList() 실행!");
		
		$.ajax("getJsonBoardList.do",{
			type : "get",
			dataType : "json",
			success : function(data) {
				alert("ajax 성공");
				console.log(data);
				
				let dispTag = "<ul>";
					for (board of data) {
						dispTag +="<li>";
						dispTag += board.seq +", ";
						dispTag += board.title +", ";
						dispTag += board.writer +", ";
						dispTag += board.content +", ";
						dispTag += board.regdate;
						dispTag +="</li>";					
					}
					dispTag += "</ul>";
					$("#listDisp").html(dispTag);
			},
			error : function(){
				alert("error 발생 : ajax 실패");
			}
		});
	}
</script>
</head>
<body>
	
	<div id="container">
		<h1>게시판 프로그램</h1>
		<hr>
		<p>
			<a href="user/login.do">로그인 페이지로 이동(GET)</a>
		</p>
		<hr><hr>
		
		<h2>Ajax 요청처리</h2>
		<p><a href="javascript:getJsonBoardList()">Json데이터 가져오기(BoardList)</a></p>
		<p><a href="javascript:getJsonBoard()">Json데이터 가져오기(Board)</a></p>
		<hr>
		<div id="listDisp">
			<ul>
				<li>데이터 가져와서 출력하기</li>
			</ul>
		</div>
	</div>
	
<script>
	function getJsonBoard(){
		alert("getJsonBoard() 실행");
		
		let vo = {};
		vo.seq = 1;
		console.log(vo);
		console.log(JSON.stringify(vo)); //JSON 형식 문자열로 만들기
		
		$.ajax("getJsonBoard.do",{
			type : "post",
			data : JSON.stringify(vo), //JSON 형식 문자열
			contentType : "application/json", //server로 전송하는 contentType(컨텐츠 유형 - JSON형식) 전달
			dataType : "json", //서버로부터 응답받을 데이터 형식
			success : function(data) {
				alert("성공");
				console.log(data);
				
				let dispTag = "<ul>";
					dispTag += "<li>";
					dispTag += data.seq +", ";
					dispTag += data.title +", ";
					dispTag += data.writer +", ";
					dispTag += data.content +", ";
					dispTag += data.regdate;
					dispTag += "</li>";
					dispTag += "</ul>";
				$("#listDisp").html(dispTag);
					
			},
			error : function(){
				alert("실패");
			}
		});
	}
</script>

</body>
</html>