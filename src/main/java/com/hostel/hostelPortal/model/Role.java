package com.hostel.hostelPortal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Access(AccessType.PROPERTY)
//@Table(name="roles")
public class Role {
    @Id
    private Long roleId;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role") //call when needed
    private Set<UserRole> userRoles=new HashSet<>();

    //Constructors
    public Role() {
    }

    public Role(Long roleId, String roleName, Set<UserRole> userRoles) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    //Getters and Setters

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    //to_string method

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
