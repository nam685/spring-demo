package com.example.demo.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Showtime;
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
	
	public Optional<List<Showtime>> getWatchHistoryById(long id) {
		Optional<User> find = userRepository.findById(id);
		List<Showtime> showtimes = null;
		
		if (find.isPresent()) {
			User user = find.get();
			showtimes = user.getWatchHistory().stream().collect(Collectors.toList());
		}
		
		return Optional.of(showtimes);
	}
}
