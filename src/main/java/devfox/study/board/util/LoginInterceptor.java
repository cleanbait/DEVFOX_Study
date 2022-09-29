package devfox.study.board.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//Sessionリード
		HttpSession session = request.getSession();
		
		//ログイン情報
		String id = (String)session.getAttribute("user");
		logger.info("id : {}", id);
		
		//絶対パス確認
		logger.info("ContextPath : {}",request.getContextPath());
		
		if(id == null) {
			response.sendRedirect(request.getContextPath() + "/Signin");
			return false;
		}
		
		return true;
	}
}
