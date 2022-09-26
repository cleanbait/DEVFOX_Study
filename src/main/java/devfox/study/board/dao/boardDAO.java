package devfox.study.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

@Repository
public class boardDAO {
	
	@Autowired
	SqlSession session;

	public int write(boardVO board) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.write(board);
		if (a == 1) {
			return a;
		}
		return 0;
	}

	public ArrayList<boardVO> list() {
		boardMapper mapper = session.getMapper(boardMapper.class);
		ArrayList<boardVO> list = mapper.list();
		return list;
	}

	public boardVO getBoard(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		
		//Hits 増加
		mapper.addHits(boardnum);
		
		//getBoard データ
		boardVO a = mapper.getBoard(boardnum);
		
		return a;
	}

	public int delete(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.delete(boardnum);
		return a;
	}

	public int editBoard(boardVO board) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.editBoard(board);
		return a;
	}

	public ArrayList<replyVO> getReply(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		ArrayList<replyVO> reply = mapper.getReply(boardnum);
		return reply;
	}

	public int reply_delete(int replynum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.reply_delete(replynum);
		return a;
	}

	public int reply(replyVO reply) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.reply(reply);
		return a;
	}
}
