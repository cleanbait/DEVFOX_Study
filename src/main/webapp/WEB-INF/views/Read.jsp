<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	.Container {
		margin: 0 auto;
		width: 800px;
	}
	
	button {
		float: right;
	}
	
	.reply {
		display: flex;
	}
	
	.reply_ID {
		width: 200px;
	}
	
	.reply_comment textarea{
		width: 600px;
		height: 80px;
		max-width: 600px;
		min-width: 600px;
	}
	
	.reply_ID input[type="submit"] {
		margin-top: 5px;
		width: 177px;
		height: 40px;
		background-color: black;
		font-size: 15px;
		color: white;
		cursor: pointer;
	}
	
	.reply_ID input[type="submit"]:hover {
		background-color: white;
		color: black;
	}
	
	button {
		background-color: black;
		color: white;
		cursor: pointer;
		height: 22px;
	}
	
	button:hover {
		background-color: white;
		color: black;
	}
	
	.co_list {
        width: 800px;
        display: flex;
        justify-content: space-between;
    }
    
    .co_ID {
        width: 70px;
        word-break:break-all;
    }

    .co_comment {
        width: 50%;
        word-break:break-all;
    }

    .co_date {
        width: 100px;
    }
    
    td {
    	word-break:break-all;
    }
    
    .content {
    	word-break:break-all;
    }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function replyCheck() {
	var id = document.getElementById("user_id").value;
	var comment = document.getElementById("comment").value;

	/* コメントがブランクの場合 */
	if(comment == "") {
		alert("コメントを入力してください(정보 미입력)");
		return false;

	/* IDがブランクの場合 */
	} else if (id == "") {
		if (confirm("ログインが必要な機能です。\nログインしますか？")) {
			location.href = "Signin";
			return false;
		} else {
			return false;
		}
	}

	return true;
}
</script>
<head>
<meta charset="UTF-8">
<title>${board.title } - 掲示文</title>
</head>
<body>
	<div class="Container">
		<h1>[掲示文]</h1>
		<hr>
		<!-- 掲示文の情報 -->
		<table>
			<tr>
				<td style="font-size: 25px;"><b>${board.title }</b></td>
			</tr>
			<tr>
				<td><b>${board.user_id }</b>   |</td>
				<td><b>${board.inputdate }</b> |</td>
				<td><b>HITS ${board.hits }</b> |</td>
			</tr>
		</table>
		<hr>
		<div class="content">${board.content }</div>
		<hr>
		<div><a href="download?boardnum=${board.board_num}">${board.originalfile }</a></div>
		<!-- ログインした場合の機能 -->
		<c:if test="${user == board.user_id}">
			<button onclick="location.href='delete?boardnum=${board.board_num}'">削除</button>
			<button onclick="location.href='edit?boardnum=${board.board_num}'">書き直し</button>
		</c:if>
		<br><br>
		
		<!-- コメントの情報 -->
		<h4>コメント</h4>
		<hr>
		<div id = "comments">
		<c:forEach var="reply" items="${reply }">
			<div class="co_list">
				<div class="co_ID">${reply.user_id }</div>
				<div class="co_comment">${reply.commentt }</div>
				<div class="co_date">${reply.inputdate }</div>
				<!-- ログインした場合の機能 -->
				<c:if test="${reply.user_id == user }">
					<button onclick="location.href='reply_delete?replynum='+ ${reply.replynum} +'&boardnum='+${board.board_num }+''">削除</button>
				</c:if>
				<c:if test="${reply.user_id != user }">
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				</c:if>
			</div>
			<hr>
		</c:forEach>
		</div>
		<!-- コメントの登録 -->
		<form action="reply" method="POST" onsubmit="return replyCheck()">
			<div class="reply">
				<div class="reply_ID">
					<input type="text" id="user_id" name="user_id" readonly="readonly" value="${user }"><br>
					<input type="submit" value="登録">
					<input type="hidden" name="board_num" value="${board.board_num }">
				</div>
				<div class="reply_comment">
					<textarea placeholder="comment" name="commentt" id="comment"></textarea>
				</div>
			</div>
		</form>
		<div class="back">
			<button onclick="location.href='Board'">掲示板に</button>
		</div>
	</div>
</body>
</html>