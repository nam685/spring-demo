package com.example.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public Optional<User> findById (long id) {
		return userRepository.findById(id);
	}
	
	public User add(User param) {
		User user = new User();
		BeanUtils.copyProperties(param, user, "id");
		userRepository.save(user);
		
		return user;
	}
	
	public Optional<User> update(User param) {
		Optional<User> find = userRepository.findById(param.getId());
		User user = null;
		
		if (find.isPresent()) {
			user = find.get();
			BeanUtils.copyProperties(param, user, "id");
			userRepository.save(user);
		}
		return Optional.of(user);
	}
	
	public List<User> findBirthdayBois() {
		return userRepository.findBirthdayBois();
	}
}
