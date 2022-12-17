package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_findCustomerPersonalInfoById {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerController customerController;

    @Test
    public void findCustomerPersonalInfoById_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findCustomerPersonalInfoById_2() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findCustomerPersonalInfoById_3() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/{id}","15"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findCustomerPersonalInfoById_4() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/{id}","9"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(9))
                .andExpect(jsonPath("$.addressCustomer").value("Đà Nẵng"))
                .andExpect(jsonPath("$.birthdayCustomer").value("1990-12-04"))
                .andExpect(jsonPath("$.delFlagCustomer").value(true))
                .andExpect(jsonPath("$.emailCustomer").value("Nguyen9@gmail.com"))
                .andExpect(jsonPath("$.genderCustomer").value(true))
                .andExpect(jsonPath("$.idCardCustomer").value("1311221333"))
                .andExpect(jsonPath("$.imageCustomer").value("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4FYDcExqiB-NZf6KGOsoYg2L8rUhQVVO0w&usqp=CAU"))
                .andExpect(jsonPath("$.nameCustomer").value("Hồ Thị Hi"))
                .andExpect(jsonPath("$.phoneCustomer").value("0903111222"))
                .andExpect(jsonPath("$.pointCustomer").value(100))
                .andExpect(jsonPath("$.countries.id").value(241))
                .andExpect(jsonPath("$.customerType.id").value(4))

        ;
    }



}
