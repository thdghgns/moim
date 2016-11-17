package ac.moim.common.utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
public class StringUtil {

	public static String MapToJsonString (Map<String, String> map) {

		ObjectMapper mapper = new ObjectMapper();
		String result;

		try {
			result = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			map.clear();
			map.put("code","CONVERT_EXCEPTION");
			map.put("message", e.getMessage());

			result = MapToJsonString(map);
		}

		return result;
	}
}
