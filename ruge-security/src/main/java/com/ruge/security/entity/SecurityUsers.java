package com.ruge.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Users
 * @date 2020.07.03 10:52
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*权限集合*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<SecurityAuthorities> roles;
    /*账户没有过期*/
    private boolean accountNonExpired;
    /*账户没有锁定*/
    private boolean accountNonLocked;
    /*证书没有过期*/
    private boolean credentialsNonExpired;
    /*账户是否有效*/
    private boolean enabled;
}
