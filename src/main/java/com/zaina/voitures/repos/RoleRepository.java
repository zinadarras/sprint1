package com.zaina.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaina.voitures.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);
}
