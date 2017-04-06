package ac.moim.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

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

			System.out.println(e);
		}

		return result;
	}

	public static <T> String listToJsonString(List<T> list) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(list);

		return result;
	}
}
