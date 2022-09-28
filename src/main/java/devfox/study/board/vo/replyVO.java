package devfox.study.board.vo;

public class replyVO {
	private int replynum;		//コメントの番号
	private int board_num;		//掲示文の番号
	private String user_id;		//使用者のID
	private String commentt;	//コメントの内容
	private String inputdate;	//コメントの作成時間

	/*
	 * Getters and Setters
	 */
	
	@Override
	public String toString() {
		return "replyVO [replynum=" + replynum + ", board_num=" + board_num + ", user_id=" + user_id + ", commentt="
				+ commentt + ", inputdate=" + inputdate + "]";
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
