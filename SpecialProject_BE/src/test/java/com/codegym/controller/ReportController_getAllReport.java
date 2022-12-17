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
public class ReportController_getAllReport {

    @Autowired
    private ReportController reportController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllReport_month_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/report-price", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllReport_month_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/report-price", ""))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());

    }
    @Test
    public void getAllReport_month_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/report-price", "10000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllReport_month_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/report-price", "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.getTotalPrice").value(1.16E8))
                .andExpect(jsonPath("$.getPoinTicket").value(4))
                .andExpect(jsonPath("$.getMonthStartDate").value(5));
    }




}
