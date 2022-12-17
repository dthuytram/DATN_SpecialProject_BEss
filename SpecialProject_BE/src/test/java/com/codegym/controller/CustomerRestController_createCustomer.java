package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_createCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createCustomer_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer(null);
        customerDto.setPhoneCustomer("0369852147");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("tinh@gmail.com");
        customerDto.setIdCardCustomer("789456123");
        customerDto.setBirthdayCustomer("1999-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Hoàng Đức Tịnh");
        customerDto.setPhoneCustomer("");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("tinh@gmail.com");
        customerDto.setIdCardCustomer("789456123");
        customerDto.setBirthdayCustomer("1999-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("*****");
        customerDto.setPhoneCustomer("eqewqe");
        customerDto.setGenderCustomer(null);
        customerDto.setEmailCustomer("12313");
        customerDto.setIdCardCustomer("");
        customerDto.setBirthdayCustomer("");
        customerDto.setAddressCustomer("");
        customerDto.setCustomerType(0L);
        customerDto.setCountries(0L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void createCustomer_16() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("*****");
//        customerDto.setPhoneCustomer("eqewqe");
//        customerDto.setGenderCustomer(null);
//        customerDto.setEmailCustomer("12313");
//        customerDto.setIdCardCustomer("");
//        customerDto.setBirthdayCustomer("");
//        customerDto.setAddressCustomer("");
//        customerDto.setCustomerType(0L);
//        customerDto.setCountries(0L);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/customer/create")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createCustomer_17() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("*****");
//        customerDto.setPhoneCustomer("eqewqe");
//        customerDto.setGenderCustomer(null);
//        customerDto.setEmailCustomer("12313");
//        customerDto.setIdCardCustomer("");
//        customerDto.setBirthdayCustomer("");
//        customerDto.setAddressCustomer("");
//        customerDto.setCustomerType(0L);
//        customerDto.setCountries(0L);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/customer/create")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
    @Test
    public void createCustomer_18() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Hoàng Đức Tịnh");
        customerDto.setPhoneCustomer("0369852147");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("tinh@gmail.com");
        customerDto.setIdCardCustomer("789456123");
        customerDto.setBirthdayCustomer("1999-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
