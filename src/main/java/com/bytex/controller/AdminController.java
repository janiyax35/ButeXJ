package com.bytex.controller;

import com.bytex.model.ActivityLog;
import com.bytex.model.User;
import com.bytex.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Create user accounts (staff/tech)
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return adminService.createUser(user);
    }

    // View system activity logs
    @GetMapping("/activity-logs")
    public List<ActivityLog> getActivityLogs() {
        return adminService.getActivityLogs();
    }

    // Modify user permissions
    @PutMapping("/users/{userId}/role")
    public User updateUserRole(@PathVariable Long userId, @RequestBody String role) {
        return adminService.updateUserRole(userId, role);
    }

    // Remove user accounts
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
    }
}
