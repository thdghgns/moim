package ac.moim.user.service;

import ac.moim.user.dto.User;
import ac.moim.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public void saveUser(User.Request user) {
	}
}
