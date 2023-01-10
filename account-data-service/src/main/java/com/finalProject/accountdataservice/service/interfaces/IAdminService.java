package com.finalProject.accountdataservice.service.interfaces;

import com.finalProject.accountdataservice.model.Admin;
import com.finalProject.accountdataservice.model.Area;

import java.util.List;
import java.util.Optional;

public interface IAdminService {
    Admin createAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long admin_id);
    Admin updateAdminInfo(Admin admin, Long admin_id);
    Admin updateAdminArea(Area area, Long admin_id);
    void deleteAdmin(Long admin_id);
}
