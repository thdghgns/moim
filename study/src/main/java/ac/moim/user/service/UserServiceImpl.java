package ac.moim.user.service;

import ac.moim.user.dto.UserDto;
import ac.moim.user.entity.User;
import ac.moim.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Service;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public User saveUser(UserDto.Request user) {
		return userRepository.saveAndFlush(toEntity(user));
	}

	// TODO : cache 삭제 적용
	@Override
	public User saveUser(Person person) {
		return userRepository.saveAndFlush(personToUser(person));
	}

	// TODO : cache 적용
	@Override
	public User getUser(String userId) {
		try{
		return userRepository.findOne(userId);
		}catch(Exception ex){
			throw ex;
		}

	}

	public void UserCreateOrUpdate(User user){
		userRepository.saveAndFlush(user);
	}
	
	private User personToUser(Person person) {
		User user = new User();

		user.setId(person.getId());
		user.setName(person.getGivenName());
		user.setMail(person.getAccountEmail());
		user.setGender(person.getGender());
		user.setBirthday(person.getBirthday());
		user.setIntro(person.getAboutMe());

		return user;
	}

	private User toEntity(UserDto.Request request) {
		User user = new User();

		user.setId(request.getId());
		user.setName(request.getName());
		user.setMail(request.getMail());
		user.setGender(request.getGender());
		user.setBirthday(request.getBirthday());
		user.setIntro(request.getIntro());

		return user;
	}
}
