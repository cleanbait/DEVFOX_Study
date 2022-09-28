package devfox.study.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

@Repository
public class boardDAO {
	
	@Autowired
	SqlSession session;

	//DBインサート
	public int write(boardVO board) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.write(board);
		if (a == 1) {
			return a;
		}
		return 0;
	}

	// 掲示物のセレクト
	public ArrayList<boardVO> list(String searchText, int startRecord, int countPerPage) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		ArrayList<boardVO> list = mapper.list(searchText, rb);
		return list;
	}

	//掲示文セレクト
	public boardVO getBoard(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		
		//Hits 増加
		mapper.addHits(boardnum);
		
		//getBoard データ
		boardVO a = mapper.getBoard(boardnum);
		
		return a;
	}

	//掲示文デリート
	public int delete(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.delete(boardnum);
		return a;
	}

	//掲示文の書き直し
	public int editBoard(boardVO board) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.editBoard(board);
		return a;
	}

	//コメントセレクト
	public ArrayList<replyVO> getReply(int boardnum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		ArrayList<replyVO> reply = mapper.getReply(boardnum);
		return reply;
	}

	//コメントのデリート
	public int reply_delete(int replynum) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.reply_delete(replynum);
		return a;
	}

	//コメントのインサート
	public int reply(replyVO reply) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int a = mapper.reply(reply);
		return a;
	}
	
	//掲示物数照会
	public int getTotal(String searchText) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		int total = mapper.getTotal(searchText);
		return total;
	}
}
