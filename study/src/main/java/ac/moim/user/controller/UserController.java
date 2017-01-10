package ac.moim.user.controller;

import ac.moim.common.dto.CityDto;
import ac.moim.common.dto.StateDto;
import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.City;
import ac.moim.common.service.CityService;
import ac.moim.common.service.StateService;
import ac.moim.common.service.SubjectService;
import ac.moim.user.entity.User;
import ac.moim.user.service.UserService;

import java.util.List;

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
	
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable(value = "userId")String userId) {

		User user = userService.getUser(userId);
		return "views/mypage/myInfo";
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMyInfo(String userId, ModelMap model) {
			

	//	User user = userService.getUser(userId);
		List<CityDto.Response> cityList = cityService.getAllCity();
		List<StateDto.Response> stateList = stateService.getAllState();
		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();

		model.addAttribute("cityList",cityList);
		model.addAttribute("stateList",stateList);
		model.addAttribute("subjectList",subjectList);
	
		return "views/mypage/update";
	}
}
