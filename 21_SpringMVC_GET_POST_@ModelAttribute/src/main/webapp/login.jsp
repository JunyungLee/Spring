<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#container { width: 700px; margin: auto; }
	h1 { text-align: center; }
	table { border-collapse: collapse; }
	
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: azure; }
	#loginbtn {float: right;}
</style>
</head>
<body>
\${userVO } : ${userVO }<br>
\${user } : ${user } <!--@ModelAttribute 사용 -> user로 명칭 부여 : user 사용해서 값 가져오기  -->

<div id="container">
	<h1>로그인 [login.jsp]</h1>
	<form action="login.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="${user.id }"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="password" value="${user.password }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" id="loginbtn">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>



