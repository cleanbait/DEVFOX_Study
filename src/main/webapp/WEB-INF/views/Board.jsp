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

<script type="text/javascript">
	function pagingFormSubmit(currentPage) {
		var form = document.getElementById("pagingForm");
		var page = document.getElementById("page");

		page.value = currentPage;
		form.submit();
	}
</script>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
	<div class="board_table">
	<h2>[掲示板] ${navi.totalRecordsCount }</h2>
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
		<br>
		
		<!-- 페이징 처리 -->
		<div id="navigator">
			<a href="javascript:pagingFormSubmit(${navi.currentPage - navi.pagePerGroup })"><<</a>
			&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage - 1 })">Previous</a>
			&nbsp;&nbsp;
			<!-- 페이지 수 만큼 반복 -->
			<c:forEach var="counter" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
				<c:if test="${counter == navi.currentPage }"><b></c:if>
					<a href="javascript:pagingFormSubmit(${counter })">${counter }</a>
				<c:if test="${counter == navi.currentPage }"></b></c:if>
			</c:forEach>
			&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage + 1 })">Next</a>
			&nbsp;&nbsp;
			<a href="javascript:pagingFormSubmit(${navi.currentPage + navi.pagePerGroup })">>></a>
		</div>
		
		<!-- 검색 처리 -->
		<br>
		<form id="pagingForm" method="get" action="Board">
			<input type="hidden" name="page" id="page">
			제목 : <input type="text" name="searchText" value="${searchText }">
			<input type="button" onclick="pagingFormSubmit(1)" value="검색">
		</form>
		
		<div class="inter">
		<button onclick="location.href='write'">Write</button>
		<button onclick="location.href='Main'">Main</button>
		</div>
	</div>
</body>
</html>