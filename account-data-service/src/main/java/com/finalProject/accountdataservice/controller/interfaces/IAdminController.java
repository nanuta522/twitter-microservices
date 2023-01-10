package com.finalProject.accountdataservice.controller.interfaces;

import com.finalProject.accountdataservice.controller.dto.AdminAreaDTO;
import com.finalProject.accountdataservice.model.Admin;
import com.finalProject.accountdataservice.model.Area;

import java.util.List;

public interface IAdminController {
    Admin createAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long admin_id);
    Admin updateAdminInfo(Admin admin, Long admin_id);
    Admin updateAdminArea(AdminAreaDTO adminAreaDTO, Long admin_id);
    void deleteAdmin(Long admin_id);
}
