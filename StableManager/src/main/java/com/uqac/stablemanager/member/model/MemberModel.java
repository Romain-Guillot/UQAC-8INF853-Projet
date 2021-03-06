package com.uqac.stablemanager.member.model;

import com.uqac.stablemanager.security.model.RoleModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class MemberModel implements UserDetails {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String postalAddress;
    private Date registerAt;
    private Date birthDate;
    private String password;
    private RoleModel role;

    public MemberModel() { }

    public MemberModel(MemberModel member) {
        id = member.id;
        firstName = member.firstName;
        lastName = member.lastName;
        email = member.email;
        postalAddress = member.postalAddress;
        registerAt = member.registerAt;
        birthDate = member.birthDate;
        password = member.password;
        role = member.role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role == null ? Collections.emptyList() : role.getRights();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public String getAccountType() {
        return "Membre";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "#" + id + " " + firstName + " " + lastName;
    }
}
