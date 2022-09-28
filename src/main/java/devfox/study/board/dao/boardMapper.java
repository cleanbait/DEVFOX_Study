package devfox.study.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

public interface boardMapper {

	//掲示文インサート
	public int write(boardVO board);

	//Hits 増加
	public void addHits(int boardnum);

	//掲示文セレクト
	public boardVO getBoard(int boardnum);

	//掲示文デリート
	public int delete(int boardnum);

	//掲示文の書き直し
	public int editBoard(boardVO board);

	//コメントをセレクト
	public ArrayList<replyVO> getReply(int boardnum);

	//コメントのデリート
	public int reply_delete(int replynum);

	//コメントのインサート
	public int reply(replyVO reply);

	//掲示物数照会
	public int getTotal(String searchText);
	
	//掲示板セレクト
	public ArrayList<boardVO> list(String searchText, RowBounds rb);
}
