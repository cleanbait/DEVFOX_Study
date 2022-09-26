package devfox.study.board.dao;

import java.util.ArrayList;

import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

public interface boardMapper {

	int write(boardVO board);

	ArrayList<boardVO> list();

	void addHits(int boardnum);

	boardVO getBoard(int boardnum);

	int delete(int boardnum);

	boardVO edit(int boardnum);

	int editBoard(boardVO board);

	ArrayList<replyVO> replyData(replyVO reply);

	ArrayList<replyVO> getReply(int boardnum);

	int reply_delete(int replynum);

	int reply(replyVO reply);

}
