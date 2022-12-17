//package com.codegym.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TicketRestController_GetHistoryPayment {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void getTicketHistoryByIdCustomer_id_7() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/ticket/list/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void getTicketHistoryByIdCustomer_id_8() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/ticket/list/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void getTicketHistoryByIdCustomer_id_9() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/ticket/list/{id}", "6"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void getTicketHistoryByIdCustomer_id_10() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/ticket/list/{id}", "1"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//}
