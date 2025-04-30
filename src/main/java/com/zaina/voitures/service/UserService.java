package com.zaina.voitures.service;

import com.zaina.voitures.entities.Role;
import com.zaina.voitures.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);

}
