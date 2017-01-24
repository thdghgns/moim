package ac.moim.common.controller;

import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.Subject;
import ac.moim.common.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllSubject(Model model) {
		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		model.addAttribute("subjectList", subjectList);

		return "";
	}
}
