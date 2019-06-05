package idu.cs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idu.cs.Entity.UserEntity;
import idu.cs.domain.User;
import idu.cs.repository.UserRepository;

@Service("userService")
public class UserServicelmpl implements UserService {
	@Autowired UserRepository repository;

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserId(String userId) {
		//DB, repository에서 가져와 Entity에 저장
		//Userrepository
		UserEntity entity = repository.findByUserId(userId);
		//Entity룰 Service, Controller에서 사용하기 위해 Domain으로 변환
		User user = entity.buildDomain();
		return user;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = repository.findAll();
		for(UserEntity entity : entities) {
			/*
			 * entity -> domain
			 */
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}

	@Override
	public List<User> getUsersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		UserEntity entity = new UserEntity();
		/*
		 * domain-user 객체를 entity-userEntity 생성
		 * DB 저장을 위해 Repository가 Entity를 필요로 함
		 */
		entity.buildEntity(user);
		repository.save(entity);

	}

	@Override
	public void updateUser(User User) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub

	}

}