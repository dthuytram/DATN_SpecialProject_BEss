package com.tramdt.service.search;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchCriteria {
    private String key;
    private String operation;
    private List<String> values;

    public SearchCriteria() {
        this.values = new ArrayList<>();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public SearchCriteria(String key, String operation, String... values) {
        this.key = key;
        this.operation = operation;
        this.values = new ArrayList<>();
        this.values.addAll(Arrays.asList(values));
    }
}
