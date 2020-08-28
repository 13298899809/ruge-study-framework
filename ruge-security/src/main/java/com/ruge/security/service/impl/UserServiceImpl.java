package com.ruge.security.service.impl;

import com.ruge.security.entity.SecurityAuthorities;
import com.ruge.security.entity.SecurityUsers;
import com.ruge.security.repository.UserRepository;
import com.ruge.security.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserServiceImpl
 * @date 2020.07.08 09:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUsers user = userRepository.findByUsername(username);
        if (user == null) {
            SecurityUsers securityUsers = new SecurityUsers();
            securityUsers.setUsername(username);
            securityUsers.setPassword(passwordEncoder.encode("123"));
            securityUsers.setRoles(Collections.singletonList(new SecurityAuthorities("ROLE_normal")));
            userRepository.save(securityUsers);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SecurityAuthorities role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        UserDetails userDetails = new User(username, user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), authorities);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userDetails;
    }
}
