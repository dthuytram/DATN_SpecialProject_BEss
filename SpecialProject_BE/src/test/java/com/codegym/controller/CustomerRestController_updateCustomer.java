package com.tramdt.controller;

import com.tramdt.dto.cop.CustomerDto;
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
public class CustomerRestController_updateCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateCustomer_19() throws Exception {
        CustomerDto customerDto =new CustomerDto();
        customerDto.setNameCustomer(null);
        customerDto.setPhoneCustomer("0963582456");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("codegym@gmail.com");
        customerDto.setIdCardCustomer("798876542" );
        customerDto.setBirthdayCustomer("1995-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customer/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_20() throws Exception {

        CustomerDto customerDto =new CustomerDto();
        customerDto.setNameCustomer("");
        customerDto.setPhoneCustomer("0963582456");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("codegym@gmail.com");
        customerDto.setIdCardCustomer("798876542" );
        customerDto.setBirthdayCustomer("1995-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customer/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_21() throws Exception {

        CustomerDto customerDto =new CustomerDto();
        customerDto.setNameCustomer("*******");
        customerDto.setPhoneCustomer("khong duoc");
        customerDto.setGenderCustomer(null);
        customerDto.setEmailCustomer("codegym");
        customerDto.setIdCardCustomer("idcard" );
        customerDto.setBirthdayCustomer("17-07-1995");
        customerDto.setAddressCustomer("");
        customerDto.setCustomerType(0L);
        customerDto.setCountries(0L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customer/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_24() throws Exception {

        CustomerDto customerDto =new CustomerDto();
        customerDto.setNameCustomer("Nguyễn Văn Anh");
        customerDto.setPhoneCustomer("0963582456");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("codegym@gmail.com");
        customerDto.setIdCardCustomer("798876542" );
        customerDto.setBirthdayCustomer("1995-12-12");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setCustomerType(5L);
        customerDto.setCountries(10L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customer/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
