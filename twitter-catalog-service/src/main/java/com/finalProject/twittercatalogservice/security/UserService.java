/*
package com.finalProject.twittercatalogservice.security;

import Laundry.model.User;
import Laundry.repository.UserRepository;
import com.finalProject.twittercatalogservice.model.Account;
import com.finalProject.twittercatalogservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = catalogService.getUserByEmail(email)
        if (user.isEmpty())
            throw new UsernameNotFoundException("User: " + email + " does not exist");

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + account.instanceOf()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
        return userDetails;
    }
}
*/
