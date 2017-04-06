package ac.moim.dashboard.controller;

import ac.moim.dashboard.dto.StudyDashboardDto;
import ac.moim.dashboard.entity.StudyDashboard;
import ac.moim.dashboard.service.StudyDashboardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ac.moim.common.utils.StringUtil.listToJsonString;


/**
 * Created by thdghgns on 2017. 4. 5..
 */
@Controller
@Slf4j
@RequestMapping(value = "/study")
public class StudyDashboardController {

    @Autowired
    StudyDashboardService studyDashboardService;

    @RequestMapping(value = "/{studyId}/dashboard", method = RequestMethod.GET)
    @ResponseBody
    public String getAllStudyDashboard(@PathVariable Integer studyId, Model model, Pageable pageable) throws JsonProcessingException {
        List<StudyDashboard> allByStudy = studyDashboardService.findAllByStudy(studyId, pageable);

        return listToJsonString(allByStudy);
    }

    @RequestMapping(value = "/{studyId}/dashboard", method = RequestMethod.POST)
    public String saveStudyDashboard(@PathVariable(required = true) Integer studyId, Model model,
                                     @RequestBody(required = true) StudyDashboardDto.Request request,
                                     BindingResult bindingResult) {
        return null;
    }
}
