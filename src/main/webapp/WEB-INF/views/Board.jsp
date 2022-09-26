<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	.board_table {
		margin: 0 auto;
		width: 1000px;
		height: 800px;
	}
	
	.inter {
		float: right;
	}
	
	th {
		height: 40px;
		padding: 10px;
	}
	
	td {
		height: 30px;
		padding-left: 5px;
		padding-right: 5px;
	}
	
	button {
	margin-top: 10px;
	float: right;
	cursor: pointer;
	background-color: white;
	color: black;
	width: 100px;
	height: 30px;
	font-size: 20px;
	}
	
	button:hover {
	background-color: black;
	color: white;
	}
</style>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
	<div class="board_table">
	<h2>[掲示板]</h2>
		<table border="1">
			<tr>
				<th>NUM</th>
				<th width="500px;">TITLE</th>
				<th width="100px;">ID</th>
				<th width="200px;">DATE</th>
				<th>HITS</th>
			</tr>
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.board_num }</td>
				<td><a href="Read?boardnum=${list.board_num }">${list.title }</a></td>
				<td>${list.user_id }</td>
				<td>${list.inputdate } </td>
				<td>${list.hits }</td>
			</tr>
			</c:forEach>
		</table>
		<div class="inter">
		<button onclick="location.href='write'">Write</button>
		<button onclick="location.href='Main'">Main</button>
		</div>
	</div>
</body>
</html>