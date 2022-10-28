package devfox.study.board.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import devfox.study.board.util.FileService;

import devfox.study.board.dao.boardDAO;
import devfox.study.board.util.PageNavigator;
import devfox.study.board.vo.boardVO;
import devfox.study.board.vo.replyVO;

@Controller
public class boardController {
	
	@Autowired
	boardDAO dao;
	
	//ページングの掲示物数
	final int countPerPage = 10;
	//ページングのグループ
	final int pagePerGroup = 5;
	//path
	final String uploadPath = "c:/boardfile";
	
	//掲示板リストのページ移動
	@RequestMapping(value = "Board", method = RequestMethod.GET)
	public String Board(@RequestParam(value="page", defaultValue = "1") int page,
						@RequestParam(value="searchText", defaultValue = "") String searchText,
						Model model) {
		//ページ計算のため、掲示物数照会
		int total = dao.getTotal(searchText);
		
		//ページングのオブジェクト
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		// 掲示物のセレクト
		ArrayList<boardVO> list = dao.list(searchText, navi.getStartRecord(), navi.getCountPerPage());
		
		model.addAttribute("list", list);
		model.addAttribute("searchText", searchText);
		model.addAttribute("navi", navi);
		return "Board";
	}
	
	//ライトの掲示板ページに
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	//ライトのデータ、DBインサート
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(boardVO board, MultipartFile upload) {
		
		if (!upload.isEmpty()) {
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavefile(savedfile);
		}
		//DBインサート
		if (dao.write(board) == 1) {
			return "redirect:/Board";
		}
		
		return "write";
	}
	
	//リードの掲示板に
	@RequestMapping(value = "Read", method = RequestMethod.GET)
	public String Read(Model model,int boardnum) {
		//board_numを参照して掲示文をセレクト
		boardVO board = dao.getBoard(boardnum);
		//board_numを参照してコメントをセレクト
		ArrayList<replyVO> reply = dao.getReply(boardnum);
		
		model.addAttribute("reply", reply);
		model.addAttribute("board", board);
		return "Read";
	}
	
	//リードのデリート
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int boardnum) {
		if(dao.delete(boardnum) == 1) {
			return "redirect:/Board";
		}
		return "Read";
	}
	
	//リードの書き直しに
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model,int boardnum) {
		//リードの文章をセレクト
		boardVO board = dao.getBoard(boardnum);
		model.addAttribute("board", board);
		return "edit";
	}
	
	//リードの書き直し
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(boardVO board) {
		if(dao.editBoard(board) == 1) {
			//書き直したページに
			return "redirect:/Read?boardnum=" + board.getBoard_num() + "";
		}
			return "edit";
	}
	
	//コメントのインサート
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(replyVO reply) {
		System.out.println(reply);
		//コメントのインサート
		if(dao.reply(reply)== 1) {
			//コメントしたページに
			return "redirect:/Read?boardnum=" + reply.getBoard_num() + "";
		}
			return null;
	}
	
	//コメントのデリート
	@RequestMapping(value = "reply_delete", method = RequestMethod.GET)
	public String reply_delete(int replynum,int boardnum) {
		System.out.println(boardnum);
		if(dao.reply_delete(replynum) == 1) {
			//コメントしたページに
			return "redirect:/Read?boardnum=" + boardnum + "";
		}
			return null;
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public String fileDownload(int boardnum, HttpServletResponse response) {
		boardVO board = dao.getBoard(boardnum);
		String originalfile = board.getOriginalfile();
		
		try {
			response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(originalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// save path
		String fullPath = uploadPath + "/" + board.getSavefile();
		
		// inputStream
		FileInputStream filein = null;	
		ServletOutputStream fileout = null; 
		
		try {
			filein = new FileInputStream(fullPath);
			fileout = response.getOutputStream();
			
			// utill
			FileCopyUtils.copy(filein, fileout);
			
			filein.close();
			fileout.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
