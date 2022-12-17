package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class TicketController_deleteListTicketByIdDto {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteTicketById_25()throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/ticket/api/delete/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteTicketById_26()throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/ticket/api/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteTicketById_27()throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/ticket/api/delete/{id}", "50"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteTicketById_28()throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/ticket/api/delete/{id}", "10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
