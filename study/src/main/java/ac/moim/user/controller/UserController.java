package ac.moim.user.controller;

import ac.moim.common.dto.CityDto;
import ac.moim.common.dto.StateDto;
import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.City;
import ac.moim.common.service.CityService;
import ac.moim.common.service.StateService;
import ac.moim.common.service.SubjectService;
import ac.moim.user.entity.User;
import ac.moim.user.repository.UserRepository;
import ac.moim.user.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 * Updated by LEE_DOYOUNG on 2017-01-07.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;	
	@Autowired
	private CityService cityService;
	@Autowired 
	private StateService stateService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public String getUser(ModelMap model, @PathVariable(value = "userId")String userId) {

		User user = userService.getUser(userId);
		model.addAttribute("user", user);

		return "views/mypage/myInfo";
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchMyInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
			
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		User user = userService.getUser(userId);
		List<CityDto.Response> cityList = cityService.getAllCity();
		List<StateDto.Response> stateList = stateService.getAllState();
		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		//StateDto.Response userState = stateService.getState(user.getCityId().getStateId())
		
				
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String userBirthday ;
		
		if (user.getBirthday() != null){
			userBirthday= sdf.format(user.getBirthday());
			model.addAttribute("userBirthdate",userBirthday);
		}
		
		
				

		model.addAttribute("cityList",cityList);
		model.addAttribute("stateList",stateList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("user",user);
		
	
		return "views/mypage/update";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMyInfo(HttpSession session, User user) {
		String userId = (String)session.getAttribute("userId");
		user.setId(userId);
		userService.UserCreateOrUpdate(user);
		return "/mypageMyIfo";
	}
}
