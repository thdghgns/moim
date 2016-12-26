package ac.moim.user.service;

import ac.moim.user.dto.UserDto;
import org.springframework.social.google.api.plus.Person;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface UserService {
	public void saveUser(UserDto.Request user);
	public ac.moim.user.entity.User saveUser(Person person);
}
