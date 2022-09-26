<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
	a input[class=login] {
		font-size: 20px;
		width: 200px;
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
		width: 405px;
		height: 100px;
		background-color: white;
	}
	
	a input[class=board]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
</style>
<head>
	<title>Home</title>
</head>
<body>
<h1>DEVFOX_KIMDONGJU_BOARD</h1>
<c:if test="${user != null }">
	<b>ようこそ ${user } 様</b><br>
</c:if>
<a href="Signup"><input type="button"  class="login" value="Sign Up"></a>
<c:if test="${user == null }">
	<a href="Signin"><input type="button"  class="login" value="Sign In"></a>
</c:if>
<c:if test="${user != null }">
	<a href="Logout"><input type="button" class="login" value="Logout"></a>
</c:if>
<p><a href="Board"><input type="button" class="board" value="Board"></a></p>
</body>
</html>
