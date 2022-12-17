package com.tramdt.exception.excep;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;


@NoArgsConstructor
public class ViolatedException extends Exception {

    private BindingResult bindingResult;

    public ViolatedException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }


    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
