package com.tramdt.model;

import com.tramdt.model.secure.ICheckingSignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.Date;

public class SignForm implements Validator {
    @Autowired
    ICheckingSignUpForm checkingSignUpForm;
    @Email
    @NotBlank
    private String email;
    @Size(min = 8,max = 20)
    @NotBlank
    private String password;
    private String confirmPassword;
    @NotBlank
    @Pattern(regexp = "(\\+849|09)+[0-9]{8}")
    private String phone;
    @Size(min = 10, max = 50)
    @NotBlank
    private String fullName;
    @NotBlank
    private String birthday;
    @NotBlank
    private String address;
    @NotNull
    private Boolean gender;
    @NotBlank
    @Pattern(regexp = "[0-9]{12}")
    private String idCard;

    public SignForm() {
    }

    public SignForm(String email, String password, String confirmPassword, String phone,
                    String fullName, String birthday,
                    String address, Boolean gender, String idCard) {

        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        SignForm signForm = (SignForm) target;
        String errorPs = checkingSignUpForm.checkPs(signForm);
        if(errorPs!=""){
            errors.rejectValue("passError", "", "Phải giống với mật khẩu");
        }

        //confirmPs equal ps
        if (!signForm.getConfirmPassword().equals(signForm.getPassword())) {
            errors.rejectValue("confirmPassword", "", "Phải giống với mật khẩu");
        }

        //check birthday
        String errorAge = checkingSignUpForm.checkBirthday(signForm);
        if(errorAge!=""){
            errors.rejectValue("ageError","","Tuổi phải lớn lớn 18 và nhỏ hơn 150");
        }
    }

}
