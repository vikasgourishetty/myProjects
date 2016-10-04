package com.vikas.groundrun.tool.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vikas.groundrun.tool.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.email = ?1")
	User findByEmail(String email);

}
