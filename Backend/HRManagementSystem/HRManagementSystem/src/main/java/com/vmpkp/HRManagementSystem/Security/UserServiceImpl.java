package com.vmpkp.HRManagementSystem.Security;


import com.vmpkp.HRManagementSystem.Models.UserEntity;
import com.vmpkp.HRManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> user = userRepository.findByUsername(username);

        return user.map(UserDetailsImpl::new).orElseThrow(()->new UsernameNotFoundException("Username Not Found"));

    }
}
