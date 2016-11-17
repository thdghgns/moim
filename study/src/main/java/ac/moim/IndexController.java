package ac.moim;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.moim.common.utils.StringUtil;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
@RestController
public class IndexController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Welcome(HttpServletRequest request, HttpServletResponse response) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("code", "WELCOME");
		map.put("message", "welcome to study moim");

		return StringUtil.MapToJsonString(map);
	}
}
