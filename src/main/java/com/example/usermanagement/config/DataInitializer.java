package com.example.usermanagement.config;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Check if default user already exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            // Create default admin user
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setEmail("admin@example.com");
            adminUser.setFirstName("Admin");
            adminUser.setLastName("User");
            userRepository.save(adminUser);
            System.out.println("Default admin user created: username=admin, password=admin123");
        }

        // Create a test user
        if (userRepository.findByUsername("test").isEmpty()) {
            User testUser = new User();
            testUser.setUsername("test");
            testUser.setPassword(passwordEncoder.encode("test123"));
            testUser.setEmail("test@example.com");
            testUser.setFirstName("Test");
            testUser.setLastName("User");
            userRepository.save(testUser);
            System.out.println("Default test user created: username=test, password=test123");
        }
    }
}
