package com.bytex.service;

import com.bytex.model.ActivityLog;
import com.bytex.model.User;
import com.bytex.repository.ActivityLogRepository;
import com.bytex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    // Create user accounts (staff/tech)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // View system activity logs
    public List<ActivityLog> getActivityLogs() {
        return activityLogRepository.findAll();
    }

    // Modify user permissions
    public User updateUserRole(Long userId, String role) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setRole(role);
            return userRepository.save(user);
        }
        return null;
    }

    // Remove user accounts
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
