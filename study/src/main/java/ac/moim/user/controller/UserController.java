package ac.moim.user.controller;

import ac.moim.user.entity.User;
import ac.moim.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable(value = "userId")String userId) {

		User user = userService.getUser(userId);
		return "";
	}
}
