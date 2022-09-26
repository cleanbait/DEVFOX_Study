package devfox.study.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//メインホームページ移動
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("Main");
		return "home";
	}
	
	@RequestMapping(value = "Main", method = RequestMethod.GET)
	public String Main() {
		return "redirect:/";
	}
}
