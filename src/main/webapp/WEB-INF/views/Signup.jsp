<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var flag = false;

	//情報確認
	function FormCheck() {
		var id = document.getElementById("id");
		var pw = document.getElementById("password");
		var pw2 = document.getElementById("password2");
		var name = document.getElementById("name");

		if (id.value == "" || pw.value == "" || pw2.value == "" || name.value == "") {
			alert("入力していない情報があります(정보 미입력)");
			return false;
		} else if (pw.value != pw2.value) {
			alert("パスワードが間違っています(패스워드 잘못입력)");
			return false;
		}

		return true;
	}
	//ID重複チェックボタン
	function IdCheck() {
		var id = document.getElementById("id").value;
		console.log(id);
		$.ajax({
			url : "IdCheck",
			type : "post",
			data : {
				"id" : id
				},
				success : function(newId) {
					//alert(newId);
					if(newId == ""){
						flag = false;
						alert("存在しているIDです(DB에 아이디가 있을 시)");
						//alert(flag);
					} else {
						flag = true;
						alert("可能なIDです");
						document.getElementById("id").readOnly=true;	//readOnly
						//alert(flag);
					}
				}, error(request, status, error) {
					alert("失敗");
					console.log(request);
				}
		});	
	}

	//ID重複チェック
	function checkIdFlag() {
		if (flag == true) {
			return true;
		} else {
			alert("ID重複チェックお願いします(중복체크 안눌렀을 시)");
			return false;
		}
	}
	
</script>
<style>
	h1 {
		text-align: center;
	}
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
		width: 270px;
		height: 400px;
		padding: 10px;
		margin: 0 auto;
	}
	
	form {
		margin-left: 12px;
	}
	
	input[type="button"] {
		font-size: 11px;
		width: 50px;
		height: 20px;
		background-color: white;
	}
	
	input[type="button"]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
	}
</style>
<head>
<meta charset="UTF-8">
<title>新規・登録</title>
</head>
<body>
<div>
	<h1>新規・登録</h1>
	<form action="Signup" method="post" onsubmit="return (FormCheck() && checkIdFlag());">
		<p><b>ID</b><span style="color: red;">*</span></p>
		<p><input type="text" name="user_id" id="id" placeholder="ユーザID"> <input type="button" value="確認" onclick="IdCheck()"></p>
		<p><b>Password</b><span style="color: red;">*</span></p>
		<p><input type="password" name="password" id="password" placeholder="パスワード"></p>
		<p><input type="password" id="password2" placeholder="再入力"></p>
		<p><b>Name</b><span style="color: red;">*</span></p>
		<p><input type="text" name="name" id="name" placeholder="ネーム"></p>
		<p><input type="submit" value="登録"> <a href="/board"><input type="button"  class="move" value="Main"></a></p>
	</form>
</div>
</body>
</html>