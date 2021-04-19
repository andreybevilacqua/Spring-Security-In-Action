package com.abevilacqua.ch6smallsecuredwebapp.service;

import com.abevilacqua.ch6smallsecuredwebapp.config.security.CustomUserDetails;
import com.abevilacqua.ch6smallsecuredwebapp.entity.User;
import com.abevilacqua.ch6smallsecuredwebapp.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
            .findUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Problem during authentication!"));
        return new CustomUserDetails(user);
    }
}
