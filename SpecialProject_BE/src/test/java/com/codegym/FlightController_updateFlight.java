package com.codegym;

import com.codegym.dto.FlightDto;
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
public class FlightController_updateFlight {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void updateFlight_codeFlight_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("null");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_codeFlight_20() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_codeFlight_21() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN000");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_codeFlight_22() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("V");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_codeFlight_23() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0000000");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_fromFlight_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("null");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_fromFlight_20() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_toFlight_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("null");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_toFlight_20() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateStart_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("null");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateStart_20() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateStart_21() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:30");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateEnd_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("null");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateEnd_20() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_dateEnd_21() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_airlineType_19() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(null);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void updateFlight_24() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0038");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Đà Nẵng(DNA)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(2L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/flight/update/1")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
}
