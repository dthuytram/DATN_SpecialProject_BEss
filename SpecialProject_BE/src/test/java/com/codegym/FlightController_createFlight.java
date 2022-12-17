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
public class FlightController_createFlight {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void createFlight_codeFlight_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("null");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/flight/create")
//                .content(this.objectMapper.writeValueAsString(flightDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//             .andDo(print())
//             .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_codeFlight_14() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_codeFlight_16() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("c");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_codeFlight_17() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("cqqqqqqqq");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_codeFlight_15() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN000");
//        flightDto.setFromFlight("Hồ Chí Minh (SGN)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_fromFlight_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("null");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_fromFlight_14() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_toFlight_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("null");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_toFlight_14() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateStart_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("null");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateStart_14() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateStart_15() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:30");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateEnd_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:o0:00");
//        flightDto.setDateEnd("null");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateEnd_14() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_dateEnd_15() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17");
//        flightDto.setAirlineType(1L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_airlineType_13() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0063");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(null);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createFlight_18() throws Exception {
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCodeFlight("VN0064");
//        flightDto.setFromFlight("Đà Nẵng (DNA)");
//        flightDto.setToFlight("Hà Nội (HAN)");
//        flightDto.setDateStart("2022-05-13 15:00:00");
//        flightDto.setDateEnd("2022-05-13 17:30:00");
//        flightDto.setAirlineType(2L);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/flight/create")
//                        .content(this.objectMapper.writeValueAsString(flightDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }

}
