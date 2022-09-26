package devfox.study.board.dao;

import devfox.study.board.vo.userVO;

public interface userMapper {

	//ID重複チェック
	public String searchUser(String id);

	//新規・登録
	public int Signup(userVO user);

	//ログイン
	public int Signin(userVO user);

}
