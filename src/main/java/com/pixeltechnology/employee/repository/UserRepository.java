package com.pixeltechnology.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeltechnology.employee.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	public Users findByUsername(String username);
	
}
