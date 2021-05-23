package com.exam.model;

import javax.persistence.*;

@Entity
@Table(name = "CR_UserRoleMapping")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleMappingId;


    //user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private  Role role;

    public UserRole() {
    }

    public long getUserRoleMappingId() {
        return userRoleMappingId;
    }

    public void setUserRoleMappingId(long userRoleMappingId) {
        this.userRoleMappingId = userRoleMappingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
