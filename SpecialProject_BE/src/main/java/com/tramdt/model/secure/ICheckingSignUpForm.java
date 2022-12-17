package com.tramdt.model.secure;


import com.tramdt.model.SignForm;

public interface ICheckingSignUpForm {
    String checkPs(SignForm form);
    String checkConfirmPs(SignForm form);
    String checkBirthday(SignForm form);
}