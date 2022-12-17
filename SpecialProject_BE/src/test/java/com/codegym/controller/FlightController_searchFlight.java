package com.codegym.controller;

import com.codegym.model.FormSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightController_searchFlight {

    @Autowired
    private MockMvc mockMvc;

    FormSearch formSearch = new FormSearch("price", "Hồ Chí Minh (SGN)", "Hà Nội (HAN)", "2022-05-13 17:30:00", "2022-05-13 15:00:00", "oneway");

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void searchFlight_from_flight_7() throws Exception {
        formSearch.setFromFlight(null);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                .content(this.objectMapper.writeValueAsString(formSearch))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_from_flight_8() throws Exception {
        formSearch.setFromFlight(null);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void searchFlight_from_flight_9() throws Exception {
        formSearch.setFromFlight("ABC");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_to_flight_7() throws Exception {
        formSearch.setToFlight(null);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_to_flight_8() throws Exception {
        formSearch.setToFlight("");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_to_flight_9() throws Exception {
        formSearch.setToFlight("ABC");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_start_7() throws Exception {
        formSearch.setDateStart(null);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_start_8() throws Exception {
        formSearch.setDateStart("");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_start_9() throws Exception {
        formSearch.setDateStart("ABC");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_end_7() throws Exception {
        formSearch.setSearchOption("twoway");
        formSearch.setDateEnd(null);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_end_8() throws Exception {
        formSearch.setSearchOption("twoway");
        formSearch.setDateEnd("ABC");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_date_end_9() throws Exception {
        formSearch.setSearchOption("twoway");
        formSearch.setDateEnd("2005-12-05 15:00:00");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchFlight_from_flight_10() throws Exception {
        formSearch.setFromFlight("Hồ Chí Minh (SGN)");
        formSearch.setToFlight("Hà Nội");
        formSearch.setDateStart("2022-05-14 14:15:00");
        formSearch.setDateEnd("2022-05-14 12:45:00");
        formSearch.setSearchOption("twoway");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/search")
                        .content(this.objectMapper.writeValueAsString(formSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
