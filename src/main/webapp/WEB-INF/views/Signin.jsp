<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	a input[class=move] {
		font-size: 11px;
		width: 50px;
		height: 20px;
		background-color: white;
	}
	
	a input[class=move]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
	
	input[type="submit"] {
		background-color: white;
		width: 180px;
		border-radius: 10px;
	}

	input[type="submit"]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
	
	div {
		border: 1px solid;
		width: 200px;
		height: 250px;
		padding: 10px;
		margin: 0 auto;
	}
</style>
<script type="text/javascript">
	function FormCheck() {
		var id = document.getElementById("id");
		var pw = document.getElementById("password");

		if(id.value == "" || pw.value == "") {
			alert("入力していない情報があります(정보 미입력)");
			return false;
		}

		return true;
	}
</script>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<div>
<h1>ログイン</h1>
<form action="Signin" method="post" onsubmit="return FormCheck()">
<p><input type="text" name="user_id" id="id" placeholder="ID"></p>
<p><input type="password" name="password" id="password" placeholder="Password"></p>
<p><input type="submit" value="ログイン"></p>
</form>
<a href="/board"><input type="button"  class="move" value="Main"></a>
<a href="Signup"><input type="button"  class="move" value="Signup"></a>
</div>
</body>
</html>