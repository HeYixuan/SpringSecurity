package org.springframe.domain;


import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by HeYixuan on 2017/4/17.
 * 用户实体
 */
@Entity
@Table(name="system_user", uniqueConstraints = {@UniqueConstraint(columnNames="username")})
public class SystemUser implements UserDetails,CredentialsContainer, Serializable {
    private static final long serialVersionUID = 8080547820663790602L;


    // ~ Instance fields
    // ================================================================================================
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "int(10)")
    private Integer id;

    /**
     * 用户名
     */
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private String username;

    /**
     * 用户密码
     */
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String password;
    /**
     * 用户邮箱
     */
    @Email
    @Column(nullable = true, columnDefinition = "varchar(36)")
    private String email;

    /**手机号码*/
    @Column(nullable = true, columnDefinition = "bigInt(11)")
    private Long phone;

    /**
     * 用户最后登录时间
     */
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private Date lastTime;

    /**
     * 用户尝试登陆次数
     */
    @Column(columnDefinition = "int(1)")
    private int attempts;

    /**
     * 账户是否过期
     */
    @Column(columnDefinition = "Boolean")
    private boolean accountNonExpired;
    /**
     * 账户是否锁定
     */
    @Column(columnDefinition = "Boolean")
    private boolean accountNonLocked;
    /**
     * 凭证是否过期
     */
    @Column(columnDefinition = "Boolean")
    private boolean credentialsNonExpired;

    /**
     * 启用状态
     */
    @Column(columnDefinition = "Boolean")
    private boolean enabled;

    /**
     * 拥有的角色
     */
    @ManyToMany
    @JoinTable(name="system_user_role",joinColumns=@JoinColumn(name="system_user_id"),
            inverseJoinColumns=@JoinColumn(name="system_role_id"))
    private Set<SystemRole> roles = new HashSet<SystemRole>();

    @Transient
    private Set<GrantedAuthority> authorities;

    // ~ Constructors
    // ===================================================================================================


    public SystemUser() {

    }

    public SystemUser(Integer id, String username, String password, String email, Long phone, Date lastTime, int attempts, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        if (((username == null) && "".equals(username)) && (password == null) && "".equals(password)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.lastTime = lastTime;
        this.attempts = attempts;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public SystemUser(String username, String password, String email, Long phone, Date lastTime, int attempts, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, Set<GrantedAuthority> authorities) {

        if (((username == null) && "".equals(username)) && (password == null) && "".equals(password)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.lastTime = lastTime;
        this.attempts = attempts;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;

    }


    // ~ Methods
    // ========================================================================================================

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void eraseCredentials() {

    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public int getAttempts() {
        return attempts;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
