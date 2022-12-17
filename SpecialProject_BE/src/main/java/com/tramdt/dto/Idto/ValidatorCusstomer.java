package com.tramdt.dto.Idto;

import com.tramdt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorCusstomer implements ConstraintValidator<ValidatorCustomer, String> {
    @Autowired
    private PassengerService passengerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (passengerService.finByIdCard(value) > 0) {
            return false;
        }
        if (passengerService.finByEmail(value) > 0) {
            return false;
        }
        if (passengerService.finByPhone(value) > 0) {
            return false;
        }
        return true;
    }
}