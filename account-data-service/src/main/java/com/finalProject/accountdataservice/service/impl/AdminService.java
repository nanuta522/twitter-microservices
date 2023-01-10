package com.finalProject.accountdataservice.service.impl;

import com.finalProject.accountdataservice.model.Admin;
import com.finalProject.accountdataservice.model.Area;
import com.finalProject.accountdataservice.repository.AdminRepository;
import com.finalProject.accountdataservice.service.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long admin_id) {
        Optional<Admin> adminOptional = adminRepository.findById(admin_id);
        if(adminOptional.isPresent()) return adminOptional.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
    }

    public Admin updateAdminInfo(Admin admin, Long admin_id) {
        Optional<Admin> adminOptional = adminRepository.findById(admin_id);
        if (adminOptional.isPresent()) {
            admin.setAccount_id(admin_id);
            adminRepository.save(admin);
            return admin;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
    }

    public Admin updateAdminArea(Area area, Long admin_id) {
        Optional<Admin> adminOptional = adminRepository.findById(admin_id);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            admin.setArea(area);
            adminRepository.save(admin);
            return admin;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
    }

    public void deleteAdmin(Long admin_id) {
        Optional<Admin> adminOptional = adminRepository.findById(admin_id);
        if (adminOptional.isPresent()) adminRepository.deleteById(admin_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
    }
}
