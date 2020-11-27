package com.atividade05.apirest.Service;

import java.util.ArrayList;

import com.atividade05.apirest.Repository.UserRepository;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.atividade05.apirest.Model.User user = userRepository.findByUsername(username);
		
		if (user.getUsername().equals(username)) {
			return new User(username, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
