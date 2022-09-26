package devfox.study.board.vo;

public class replyVO {
	private int replynum;		
	private int board_num;		
	private String user_id;	
	private String password;
	private String commentt;	
	private String inputdate;
	
	@Override
	public String toString() {
		return "replyVO [replynum=" + replynum + ", board_num=" + board_num + ", user_id=" + user_id + ", password="
				+ password + ", commentt=" + commentt + ", inputdate=" + inputdate + "]";
	}

	public int getReplynum() {
		return replynum;
	}

	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCommentt() {
		return commentt;
	}

	public void setCommentt(String commentt) {
		this.commentt = commentt;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	

}
