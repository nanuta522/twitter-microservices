package com.finalProject.accountdataservice.service.impl;

import com.finalProject.accountdataservice.model.User;
import com.finalProject.accountdataservice.repository.UserRepository;
import com.finalProject.accountdataservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public User getUserById(Long user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if(userOptional.isPresent()) return userOptional.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    public User updateUserInfo(Long user_id, User user) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) {
            user.setAccount_id(user_id);
            userRepository.save(user);
            return user;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    public void deleteUser(Long user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) userRepository.deleteById(user_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
}
