package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;

	// Create new User
	public User registerUser(User user) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return userRepository.save(user);
	}

	// Fetch all User
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	// Fetch all user by userType
	public List<User> getAlluserType(String userType) {
		List<User> userList = userRepository.findByUserType(userType);
		return userList;
	}

	// Fetch user by email
	public User getUserByEmail(String email, String userType) {
		return userRepository.findByEmail(email, userType);
	}

	// Fetch user by email and password
	public User getUserByPassword(String email, String password, String userType) {

		User user = userRepository.findByEmail(email, userType);

		if (user != null) {

			String dbpassword = user.getPassword();

			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

			if (bcrypt.matches(password, dbpassword)) {
				return user;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	// Update User
	public User updateUser(User user) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return userRepository.save(user);
	}

	// Delete User
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
}
