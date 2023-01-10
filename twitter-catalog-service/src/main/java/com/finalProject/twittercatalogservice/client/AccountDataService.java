package com.finalProject.twittercatalogservice.client;

import com.finalProject.twittercatalogservice.controller.dto.AdminAreaDTO;
import com.finalProject.twittercatalogservice.model.Admin;
import com.finalProject.twittercatalogservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("account-data-service")
public interface AccountDataService {
    @PostMapping("/api/admin")
    public Admin createAdmin(@RequestBody Admin admin);

    @GetMapping("/api/admin/all")
    public List<Admin> getAllAdmins();

    @GetMapping("/api/admin/{admin_id}")
    public Admin getAdminById(@PathVariable Long admin_id);

    @PutMapping("/api/admin/{admin_id}")
    public Admin updateAdminInfo(@RequestBody Admin admin, @PathVariable Long admin_id);

    @PatchMapping("/api/admin/{admin_id}/area")
    public Admin updateAdminArea(@RequestBody AdminAreaDTO adminAreaDTO, @PathVariable Long admin_id);

    @DeleteMapping("/api/admin/{admin_id}")
    public void deleteAdmin(@PathVariable Long admin_id);

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user);

    @GetMapping("/api/user/all")
    public List<User> getAllUsers();

    @GetMapping("/api/user/{user_id}")
    public User getUserById(@PathVariable Long user_id);

    @PutMapping("/api/user/{user_id}")
    public User updateUserInfo(@PathVariable Long user_id, @RequestBody User user);

    @DeleteMapping("/api/user/{user_id}")
    public void deleteUser(@PathVariable Long user_id);
}
