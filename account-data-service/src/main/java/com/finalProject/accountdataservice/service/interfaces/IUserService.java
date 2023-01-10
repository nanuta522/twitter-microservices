package com.finalProject.accountdataservice.service.interfaces;

import com.finalProject.accountdataservice.model.User;
import com.finalProject.accountdataservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long user_id);
    User updateUserInfo(Long user_id, User user);
    void deleteUser(Long user_id);
}
