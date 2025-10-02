package com.marques.SpringSecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marques.SpringSecurity.Model.Users;

public interface UserRepo extends JpaRepository<Users, Long>  {
    Users findByUsername(String username);
    
}
