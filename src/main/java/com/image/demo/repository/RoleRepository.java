package com.image.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.image.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
