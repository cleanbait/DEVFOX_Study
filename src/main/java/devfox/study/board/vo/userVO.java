package devfox.study.board.vo;

public class userVO {
	private String user_id;		//使用者のID
	private String password;	//使用者のパスワード
	
	
	/*
	 * Getters and Setters
	 */
	
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
	
	
	@Override
	public String toString() {
		return "userVO [user_id=" + user_id + ", password=" + password + "]";
	}
	
	
}
