<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	
	div {
		margin: 0 auto;
		width: 500px;
		height: 500px;
	}
	
	input[type="submit"] {
	float: right;
	cursor: pointer;
	background-color: white;
	color: black;
	}
	
	input[type="submit"]:hover {
	background-color: black;
	color: white;
	}
</style>
<script type="text/javascript">
	function formCheck() {
		var id = document.getElementById("user_id").value;
		var title = document.getElementById("title");
		var content = document.getElementById("content");

		if (id == "") {
			alert("ログイン必要");
			location.href = "Signin";
			return false;
		}
		
		if (title.value =="" || content.value == "") {
			alert("入力していない情報があります(정보 미입력)");
			return false;
		}

		return true;
	}
</script>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
<form action="write" method="post" onsubmit="return formCheck()">
	<div>
		<table style="text-align: center; width: 500px;">
			<tr>
				<th style="background-color: black; color: white; height: 50px;">Write</th>
			</tr>
			<tr>
				<td style="height: 50px; background-color: #f1f3f5;">
					<input type="text" id="title" name="title" placeholder="title" maxlength="100;" style="width: 90%;">
				</td>
			</tr>
			<tr>
				<td>
					<textarea id= "content" name="content" placeholder="content" maxlength="2000" style="height: 400px; width: 95%; min-width: 500px; max-width: 500px;"></textarea>
				</td>
			</tr>
		</table>
		<input type="hidden" id="user_id" name="user_id" value="${user }">
		<input type="submit" value="write" style="width: 60px; height: 30px;">
	</div>
</form>
</body>
</html>