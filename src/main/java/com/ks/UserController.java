package com.ks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.communication.EmailServices;
import com.dao.UserDAO;
import com.model.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@GetMapping("/getByUserType/{userType}")
	public List<User> getByUserType(@PathVariable("userType") String userType) {
		return userDAO.getAlluserType(userType);
	}

	@GetMapping("/getUserByEmail/{email}/{userType}/{reason}")
	public User getUserByEmail(@PathVariable("email") String email, @PathVariable("userType") String userType,
			@PathVariable("reason") String reason) {
		User user = userDAO.getUserByEmail(email, userType);
		if (reason.equals("checkUser") && user != null) {
			String otp = EmailServices.sendOTP(email);
			user.setPassword(otp);
		}
		return user;

	}

	@GetMapping("/getUserByPassword/{email}/{password}/{userType}")
	public User getUserByPassword(@PathVariable("email") String email, @PathVariable("password") String password,
			@PathVariable("userType") String userType) {
		return userDAO.getUserByPassword(email, password, userType);

	}

	@PostMapping("/registerUser")
	public String registerUser(@RequestBody User user) {

		User regUser = userDAO.registerUser(user);

		if (regUser != null)
			return regUser + "\nUser Registered into the Database";

		return "User Registeration Failed!!!";
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {

		User updUser = userDAO.updateUser(user);

		if (updUser != null)
			return updUser + "\nUser Record Updated in the Database";

		return "User Updation Failed!!!";
	}

	@DeleteMapping("/deleteEmployee/{userId}")
	public String deleteEmployee(@PathVariable("userId") int userId) {
		userDAO.deleteUser(userId);
		return "User Record Deleted Successfully!";
	}

	@GetMapping("/verifyEmail/{email}")
	public String verifyEmail(@PathVariable("email") String sendTo) {
		return EmailServices.sendOTP(sendTo);
	}
}
