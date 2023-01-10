package com.finalProject.accountdataservice.controller.impl;

import com.finalProject.accountdataservice.controller.interfaces.IUserController;
import com.finalProject.accountdataservice.model.User;
import com.finalProject.accountdataservice.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class UserController implements IUserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long user_id) {
        return userService.getUserById(user_id);
    }

    @PutMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserInfo(@PathVariable Long user_id, @RequestBody @Valid User user) {
        return userService.updateUserInfo(user_id, user);
    }

    @DeleteMapping("/{user_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "User successfully deleted")
    public void deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
    }
}
