package devfox.study.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devfox.study.board.dao.boardDAO;
import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

@Controller
public class boardController {
	
	@Autowired
	boardDAO dao;
	
	//掲示板ページ移動
	@RequestMapping(value = "Board", method = RequestMethod.GET)
	public String Board(Model model) {
		ArrayList<boardVO> list = dao.list();
		model.addAttribute("list", list);
		return "Board";
	}
	
	//쓰기 게시판 이동
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	//쓰기 데이터 전송
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(boardVO board) {
		if (dao.write(board) == 1) {
			return "redirect:/Board";
		}
		return "write";
	}
	
	//읽기 게시판 이동
	@RequestMapping(value = "Read", method = RequestMethod.GET)
	public String Read(Model model,int boardnum) {
		//게시글 번호를 참조해서 글 가져오기
		boardVO board = dao.getBoard(boardnum);
		//게시글 번호를 참조해서 리플 가져오기
		ArrayList<replyVO> reply = dao.getReply(boardnum);
		
		model.addAttribute("reply", reply);
		model.addAttribute("board", board);
		return "Read";
	}
	
	//게시글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int boardnum) {
		if(dao.delete(boardnum) == 1) {
			return "redirect:/Board";
		}
		return "Read";
	}
	
	//게시글 수정페이지 이동
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,int boardnum) {
		boardVO board = dao.getBoard(boardnum);
		model.addAttribute("board", board);
		return "edit";
	}
	
	//게시글 수정
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(boardVO board) {
		if(dao.editBoard(board) == 1) {
			return "redirect:/Read?boardnum=" + board.getBoard_num() + "";
		}
			return "edit";
	}
	
	//리플 등록
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(replyVO reply) {
		if(dao.reply(reply)== 1) {
			return "redirect:/Read?boardnum=" + reply.getBoard_num() + "";
		}
			return null;
	}
	
	//리플 삭제
	@RequestMapping(value = "reply_delete", method = RequestMethod.GET)
	public String reply_delete(int replynum,int boardnum) {
		System.out.println(boardnum);
		if(dao.reply_delete(replynum) == 1) {
			return "redirect:/Read?boardnum=" + boardnum + "";
		}
			return null;
	}
}
