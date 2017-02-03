package ac.moim.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ac.moim.user.entity.User;
import ac.moim.user.service.UserService;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		Long expireTime = (Long)session.getAttribute("expireTime");
		String userId = (String)session.getAttribute("userId");

//		if(expireTime == null || userId == null) {
//			response.sendRedirect("/login");
//			return false;
//		}
//
//		User user = userService.getUser(userId);
//
//		if(user == null) {
//			response.sendRedirect("/login");
//			return false;
//		}

		// TODO : refresh 추가
//		if (expireTime != null && expireTime < System.currentTimeMillis()) {
//			AccessGrant accessGrant = (AccessGrant)session.getAttribute("AccessGrant");
//			String accessToken = accessGrant.getRefreshToken();
//
//			session.setAttribute("expireTime", expireTime);
//		}

		return true;
	}
}