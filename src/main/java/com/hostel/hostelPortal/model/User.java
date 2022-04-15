package com.hostel.hostelPortal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Access(AccessType.PROPERTY)
//@Table(name="users") //if we want DB table name != class name
public class User {
    // @Column(name="userID",nullable=false) => if DB column name != class var name
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generated key, surrogate key
    private Long  id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled=true; // for enabling and disabling User
    private String profile;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "user")//cascading all effects
    @JsonIgnore // to avoid circular dependency
    private Set<UserRole> userRoles=new HashSet<>();

    //Constructors
    public User() {
    }

    public User(Long id, String userName, String password, String firstName, String lastName, String email, String phone, boolean enabled, Set<UserRole> userRoles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.userRoles = userRoles;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    //to_string method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                ", profile='" + profile + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }

    public String getUsername()
    {
        return userName;
    }
}
