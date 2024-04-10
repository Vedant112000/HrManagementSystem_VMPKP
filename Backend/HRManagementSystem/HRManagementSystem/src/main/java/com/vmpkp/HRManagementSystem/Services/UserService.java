package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.UserEntity;
import com.vmpkp.HRManagementSystem.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(UserEntity userEntity){

        LocalDateTime dateTime = LocalDateTime.now();

        userEntity.setCreatedAt(dateTime);
        userEntity.setUpdatedAt(dateTime);

        userEntity.encryptPassword();

        userRepository.save(userEntity);

        return "Added User Successfully";
    }

    @PostConstruct
    @Transactional
    public void setupInitialUser() {
        if (userRepository.count() == 0) {

            UserEntity user = new UserEntity();
            user.setUsername("superUserVedant");

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            user.setPassword(encoder.encode("P@ssword"));
            user.setRoles("ROLE_ADMIN");

            LocalDateTime dateTime = LocalDateTime.now();

            user.setCreatedAt(dateTime);
            user.setUpdatedAt(dateTime);

            userRepository.save(user);
        }
    }

}
