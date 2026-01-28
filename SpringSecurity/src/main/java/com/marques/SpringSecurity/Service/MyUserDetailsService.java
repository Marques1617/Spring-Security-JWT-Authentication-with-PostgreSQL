package com.marques.SpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marques.SpringSecurity.Model.UserPrincipal;
import com.marques.SpringSecurity.Model.Users;
import com.marques.SpringSecurity.Repo.UserRepo;

@Service //Implementing my own UserDetailService without using the default one
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Loading user by username: " + username);

        Users user = repo.findByUsername(username); 

        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user); //To return an object that is UserDetails, it is obligated to create a class that contains the interface UserDertails 
    }
           
}