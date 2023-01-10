package com.finalProject.accountdataservice.controller.impl;

import com.finalProject.accountdataservice.controller.dto.AdminAreaDTO;
import com.finalProject.accountdataservice.controller.interfaces.IAdminController;
import com.finalProject.accountdataservice.model.Admin;
import com.finalProject.accountdataservice.service.impl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class AdminController implements IAdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Admin createAdmin(@RequestBody @Valid Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{admin_id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin getAdminById(@PathVariable Long admin_id) {
        return adminService.getAdminById(admin_id);
    }

    @PutMapping("/{admin_id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin updateAdminInfo(@RequestBody @Valid Admin admin, @PathVariable Long admin_id) {
        return adminService.updateAdminInfo(admin, admin_id);
    }

    @PatchMapping("/{admin_id}/area")
    @ResponseStatus(HttpStatus.OK)
    public Admin updateAdminArea(@RequestBody @Valid AdminAreaDTO adminAreaDTO, @PathVariable Long admin_id) {
        return adminService.updateAdminArea(adminAreaDTO.getArea(), admin_id);
    }

    @DeleteMapping("/{admin_id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Admin successfully deleted")
    public void deleteAdmin(@PathVariable Long admin_id) {
        adminService.deleteAdmin(admin_id);
    }
}
