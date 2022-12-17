package com.codegym.controller;

import com.codegym.dto.CustomerPersonalInfoDto;
import com.codegym.model.Countries;
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
public class CustomerController_updateCustomerPersonalInfo {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String PATCH_UPDATE_URL = "/customer/edit/update";

    /* kiểm tra trường name  */
    @Test
    public void updateCustomerPersonalInfo_Name_19() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer(null);
        customerDtop.setGenderCustomer(true);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("1311221333");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomerPersonalInfo_Name_20() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("");
        customerDtop.setGenderCustomer(true);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("1311221333");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateCustomerPersonalInfo_Name_22() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Hai");
        customerDtop.setGenderCustomer(true);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("1311221333");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateCustomerPersonalInfo_Name_23() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Thien Dia Huyen Hoang Hai Hoang Thien Hai Dai La Kim Tien");
        customerDtop.setGenderCustomer(true);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("1311221333");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* test update trường hợp thành công */
    @Test
    public void updateCustomerPersonalInfo_Name_24() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(true);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("131122133345");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* kiểm tra trường gender  */
    @Test
    public void updateCustomerPersonalInfo_Gender_19() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(null);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("131122133345");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /* kiểm tra trường idCard  */
    @Test
    public void updateCustomerPersonalInfo_IdCard_19() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer(null);
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomerPersonalInfo_IdCard_20() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateCustomerPersonalInfo_IdCard_21() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("1990-12-04");
        customerDtop.setIdCardCustomer("12345678912");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*kiểm tra trường Birthday  */
    @Test
    public void updateCustomerPersonalInfo_Birthday_19() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer(null);
        customerDtop.setIdCardCustomer("123456789123");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    public void updateCustomerPersonalInfo_Birthday_20() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("");
        customerDtop.setIdCardCustomer("123456789123");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomerPersonalInfo_Birthday_21() throws Exception{
        CustomerPersonalInfoDto customerDtop = new CustomerPersonalInfoDto();

        customerDtop.setId(1l);
        customerDtop.setNameCustomer("Le Dai Phong");
        customerDtop.setGenderCustomer(false);
        customerDtop.setEmailCustomer("Nguyen1@gmail.com");
        customerDtop.setPhoneCustomer("0903111222");
        customerDtop.setBirthdayCustomer("21/22/2022");
        customerDtop.setIdCardCustomer("12345678912");
        customerDtop.setAddressCustomer("Đà Nẵng");
        customerDtop.setImageCustomer("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU");

        Countries countries = new Countries();
        countries.setId(241l);
        customerDtop.setCountries(countries);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(customerDtop))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
