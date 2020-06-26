package com.example.Todolist;


import com.example.Todolist.model.Role;
import com.example.Todolist.repository.RoleRepo;
import com.example.Todolist.repository.UserRepo;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface Dataload implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired UserRepo userRepository;

    @Autowired RoleRepo roleRepository;

    @Autowired PasswordView passwordEncoder;

    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_USER");

        Role adminRole = roleRepository.findByRolename("ROLE_ADMIN");
        Role userRole = roleRepository.findByRolename("ROLE_USER");

        User user = new User();
        user.setFirstName("Admin1");
        user.setLastName("Last1");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Arrays.asList(adminRole, userRole));

        User user2 = userRepository.findByUsername("admin");
        if (user2 == null)
            userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByRolename(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}