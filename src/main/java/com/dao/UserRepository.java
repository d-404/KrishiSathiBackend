package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// Fetch user by email
	@Query("from User u where u.email = :email AND u.userType = :userType")
	User findByEmail(@Param("email") String email ,@Param("userType") String userType);

	// Fetch user by userType
	@Query("from User u where u.userType = :userType")
	List<User> findByUserType(@Param("userType") String userType);

}
