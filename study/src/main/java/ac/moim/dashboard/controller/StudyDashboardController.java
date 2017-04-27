package ac.moim.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import ac.moim.dashboard.dto.StudyArticleDto;
import ac.moim.dashboard.entity.StudyArticle;
import ac.moim.dashboard.repository.StudyDashboardRepository;
import ac.moim.dashboard.service.StudyDashboardService;
import ac.moim.study.entity.Study;
import ac.moim.study.service.StudyService;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpSession;


/**
 * Created by thdghgns on 2017. 4. 5..
 */
@Controller
@Slf4j
@RequestMapping(value = "/study")
public class StudyDashboardController {

    @Autowired
    StudyDashboardService studyDashboardService;
    
    @Autowired
    StudyService studyService;
    
    @Autowired
    StudyDashboardRepository studyDashboardRepository;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getAllStudyDashboard(@RequestParam(value="studyId", required=true) Integer studyId, Model model, Pageable pageable) throws JsonProcessingException {
    	
    	Study study = studyService.findById(studyId);
        List<StudyArticle> studyArticles = studyDashboardService.findAllByStudy(studyId, pageable);

        model.addAttribute("study", study);
		model.addAttribute("selectedMenu", "dashboard");
		model.addAttribute("studyArticles", studyArticles);

		return "views/study/detail";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveStudyDashboard(Model model, HttpSession httpSession,
    								@RequestParam(value="studyId", required=true) Integer studyId,
                                    @RequestBody(required = true) StudyArticleDto.Request request,
                                    BindingResult bindingResult) {
    	
    	Study study = studyService.findById(studyId);
    	String userId = String.valueOf(httpSession.getAttribute("userId"));
    	
    	StudyArticle article = new StudyArticle();
    	article.setTitle(request.getTitle());
    	article.setContent(request.getContent());
    	article.setStudy(study);
    	article.setInputUser(userId);
    	article.setModifyUser(userId);
    	
    	studyDashboardRepository.saveAndFlush(article);
    	
        return "views/study/detail";
    }
    
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String getStudyArticle(@RequestParam(value="articleId", required=true) Long articleId, Model model) throws JsonProcessingException {
        
    	StudyArticle article = studyDashboardService.findOne(articleId);
    	Study study = article.getStudy();
    	
    	model.addAttribute("study", study);
		model.addAttribute("selectedMenu", "article");
		model.addAttribute("article", article);
		
		return "views/study/detail";
    }
    
    @RequestMapping(value = "/article/create-form", method = RequestMethod.GET)
    public String getStudyArticles(@RequestParam(value="studyId", required=true) Integer studyId, Model model) throws JsonProcessingException {
        
    	Study study = studyService.findById(studyId);
    	
    	model.addAttribute("study", study);
		model.addAttribute("selectedMenu", "createArticle");
		
		return "views/study/detail";
    }
}
