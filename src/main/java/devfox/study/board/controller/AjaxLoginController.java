package devfox.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devfox.study.board.dao.userDAO;


@RestController
public class AjaxLoginController {
	
	@Autowired
	userDAO dao;

	//ID重複チェック
	@RequestMapping(value = "IdCheck", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String IdCheck(String id) { 
		//DBのID検索
		if(dao.searchUser(id)) { 
			return id; 
		} else {
			return null;
		}
	}
}
