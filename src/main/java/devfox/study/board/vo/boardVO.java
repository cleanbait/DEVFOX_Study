package devfox.study.board.vo;

public class boardVO {
	private int board_num;		//掲示文のナンバー
	private String user_id;		//使用者のID
	private String title;		//掲示文のタイトル
	private String content;		//掲示文の内容
	private String inputdate;	//掲示文の作成時間
	private int hits;			//掲示文のアクセス数
	
	
	/*
	 * Getters and Setters
	 */
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getinputdate() {
		return inputdate;
	}
	public void setinputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	@Override
	public String toString() {
		return "boardVO [board_num=" + board_num + ", user_id=" + user_id + ", title=" + title + ", content=" + content
				+ ", inputdate=" + inputdate + ", hits=" + hits + "]";
	}

	
	
}
