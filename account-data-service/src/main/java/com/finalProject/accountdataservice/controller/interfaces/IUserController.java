package com.finalProject.accountdataservice.controller.interfaces;

import com.finalProject.accountdataservice.model.User;

import java.util.List;

public interface IUserController {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long user_id);
    User updateUserInfo(Long user_id, User user);
    void deleteUser(Long user_id);
}
