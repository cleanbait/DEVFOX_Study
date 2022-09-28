<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
	a input[class=login] {
		font-size: 20px;
		width: 228px;
		height: 100px;
		background-color: white;
	}
	
	a input[class=login]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
	
	a input[class=board] {
		font-size: 20px;
		width: 462px;
		height: 100px;
		background-color: white;
	}
	
	a input[class=board]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
	
	div {
		width: 500px;
		margin: 0 auto;
	}
</style>
<head>
	<title>Home</title>
</head>
<body>
<div>
	<h1>DEVFOX_KIMDONGJU_BOARD</h1>
	<!-- SessionID -->
	<c:if test="${user != null }">
		<b>ようこそ ${user } 様</b><br>
	</c:if>
	<a href="Signup"><input type="button"  class="login" value="Sign Up"></a>
	
	<!-- SessionID確認 -->
	<c:if test="${user == null }">
		<a href="Signin"><input type="button"  class="login" value="Sign In"></a>
	</c:if>
	<c:if test="${user != null }">
		<a href="Logout"><input type="button" class="login" value="Logout"></a>
	</c:if>
	<p><a href="Board"><input type="button" class="board" value="Board"></a></p>
</div>
</body>
</html>
