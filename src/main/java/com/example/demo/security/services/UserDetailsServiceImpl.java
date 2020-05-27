package com.example.demo.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> find = userRepository.findByUsername(username);
		
		if (find.isEmpty()) {
			throw new UsernameNotFoundException("Can't find username " + username);
		}
		
		User user = find.get();
		return UserDetailsImpl.build(user);
	}

}
