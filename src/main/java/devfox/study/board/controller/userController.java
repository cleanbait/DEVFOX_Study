package devfox.study.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devfox.study.board.dao.userDAO;
import devfox.study.board.vo.userVO;

@Controller
public class userController {

	@Autowired
	userDAO dao;
	
	//新規・登録ページ移動
	@RequestMapping(value = "Signup", method = RequestMethod.GET)
	public String Signup() {
		return "Signup";
	}
	
	//ログインページ移動
	@RequestMapping(value = "Signin", method = RequestMethod.GET)
	public String Signin() {
		return "Signin";
	}
	
	//新規・登録
	@RequestMapping(value="Signup", method = RequestMethod.POST)
	public String Signup(userVO user) {
		if(dao.Signup(user)) {
			return "Signin";
		}
		return "Signup";
	}
	
	//ログイン
	@RequestMapping(value="Signin", method = RequestMethod.POST)
	public String Signin(userVO user,Model model, HttpSession session) {
		if(dao.Signin(user)) {
			System.out.println(user.getUser_id());
			session.setAttribute("user", user.getUser_id());
			return "redirect:/";
		}
		//間違った場合
		model.addAttribute("not_match","ID、またはパスワードが正しくありません。");
		return "Signin";
	}
	
	//ログアウト
	@RequestMapping(value="Logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) {
		session.removeAttribute("user");
		//session.invalidate();
		return "redirect:/";
	}
}
