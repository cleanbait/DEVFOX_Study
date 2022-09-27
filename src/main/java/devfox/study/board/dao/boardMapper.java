package devfox.study.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

public interface boardMapper {

	int write(boardVO board);

	void addHits(int boardnum);

	boardVO getBoard(int boardnum);

	int delete(int boardnum);

	boardVO edit(int boardnum);

	int editBoard(boardVO board);

	ArrayList<replyVO> replyData(replyVO reply);

	ArrayList<replyVO> getReply(int boardnum);

	int reply_delete(int replynum);

	int reply(replyVO reply);

	// 検索した後のトタル文の数
	public int getTotal(String searchText);
	
	// 검색 후의 현재 페이지 목록
	ArrayList<boardVO> list(String searchText, RowBounds rb);
}
