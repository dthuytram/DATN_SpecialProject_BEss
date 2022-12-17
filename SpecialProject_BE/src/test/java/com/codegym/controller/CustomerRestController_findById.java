package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getByIdCustomer_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getByIdCustomer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getByIdCustomer_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/{id}", "50"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getByIdCustomer_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customer/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nameCustomer").value("Nguyễn Văn Anh"))
                .andExpect(jsonPath("$.genderCustomer").value(true))
                .andExpect(jsonPath("$.birthdayCustomer").value("1995-12-12"))
                .andExpect(jsonPath("$.idCardCustomer").value("798876542"))
                .andExpect(jsonPath("$.phoneCustomer").value("0963582456"))
                .andExpect(jsonPath("$.emailCustomer").value("codegym@gmail.com"))
                .andExpect(jsonPath("$.addressCustomer").value("Đà Nẵng"))
                .andExpect(jsonPath("$.delFlagCustomer").value(false))
                .andExpect(jsonPath("$.countries.id").value(10))
                .andExpect(jsonPath("$.customerType.id").value(5));

    }

}
