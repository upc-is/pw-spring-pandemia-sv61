package pe.edu.upc.pandemia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.User;
import pe.edu.upc.pandemia.model.repository.UserRepository;

@Service
public class UserService implements pe.edu.upc.pandemia.service.UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public JpaRepository<User, Integer> getRepository() {
		return userRepository;
	}

}
