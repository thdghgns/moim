package ac.moim.user.service;

import ac.moim.user.dto.UserDto;
import ac.moim.user.entity.User;
import org.springframework.social.google.api.plus.Person;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface UserService {
	public void saveUser(UserDto.Request user);
	public User saveUser(Person person);
	public User getUser(String userId);
	public void UserCreateOrUpdate(User user);
}
