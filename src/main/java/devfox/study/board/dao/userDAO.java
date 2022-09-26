package devfox.study.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import devfox.study.board.vo.userVO;

@Repository
public class userDAO {

	@Autowired
	SqlSession session;
	
	//ID重複チェック
	public Boolean searchUser(String id) {
		userMapper mapper = session.getMapper(userMapper.class);
		id = mapper.searchUser(id);
		if (id == null) {
			return true;
		}
		return false;
	}

	//新規・登録
	public boolean Signup(userVO user) {
		userMapper mapper = session.getMapper(userMapper.class);
		int a = mapper.Signup(user);
		if (a == 1) {
			return true;
		}
		return false;
		
	}
	
	//ログイン
	public boolean Signin(userVO user) {
		userMapper mapper = session.getMapper(userMapper.class);
		int a = mapper.Signin(user);
		if (a == 1) {
			return true;
		}
		return false;
	}
	
}
