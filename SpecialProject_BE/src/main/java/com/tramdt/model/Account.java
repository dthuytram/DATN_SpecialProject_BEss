package com.tramdt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    public Account(Long id, String code, String fullName, String password, LocalDate birthDate, String email, String phoneNumber, String address, String gender, String avatarImageUrl, String customerRank, String role, boolean status) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.avatarImageUrl = avatarImageUrl;
        this.customerRank = customerRank;
        this.role = role;
        this.status = status;
    }

    @Column(name = "full_name", nullable = false)
    @Size(min = 6)
    private String fullName;

    public Account() {
    }

    @Column(name = "password", nullable = false)
    @Size(min = 6)
    private String password;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar_image_url")
    private String avatarImageUrl;

    @Column(name = "customer_rank", columnDefinition = "varchar(255) default 'Thành viên'")
    private String customerRank;

    @Column(name = "role")
    @Pattern(regexp = "^(ROLE_USER|ROLE_EMPLOYEE|ROLE_ADMIN)$")
    private String role;

    @Column(name = "status")
    private boolean status;

    public Account(String email, String password, String role, boolean status,
                   String fullName,LocalDate birthDate,String avatarImageUrl,String gender ) {
        this.email = email;
        this.password =  password;
        this.role = role;
        this.status = status;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.avatarImageUrl = avatarImageUrl;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatarImageUrl() {
        return avatarImageUrl;
    }

    public void setAvatarImageUrl(String avatarImageUrl) {
        this.avatarImageUrl = avatarImageUrl;
    }

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
