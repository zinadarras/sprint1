package com.zaina.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zaina.voitures.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername (String username);
}
