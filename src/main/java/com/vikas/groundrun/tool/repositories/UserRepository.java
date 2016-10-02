package com.vikas.groundrun.tool.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.groundrun.tool.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
