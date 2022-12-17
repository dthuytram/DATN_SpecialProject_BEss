package com.codegym.controller;

import com.codegym.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightController_getListFlight {
    @Autowired
    private FlightController flightController;

//
//    @Test
//    public void getListFlight_5() {
//
//        ResponseEntity<List<Flight>> responseEntity
//                = this.flightController.getListFlight(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void getListStudent_6() {
//        ResponseEntity<Page<Flight>> responseEntity
//                = this.flightController.getListFlight(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(8, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(80, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("VN995",
//                responseEntity.getBody().getContent().get(8).getCodeFlight());
//        Assertions.assertEquals("2022-05-17 22:45:00",
//                responseEntity.getBody().getContent().get(8).getDateStart());
//        Assertions.assertEquals("2022-05-17 21:40:00",
//                responseEntity.getBody().getContent().get(8).getDateEnd());
//        Assertions.assertEquals(true,
//                responseEntity.getBody().getContent().get(8).getDelFlagFlight());
//        Assertions.assertEquals("Đà Nẵng (DAD)",
//                responseEntity.getBody().getContent().get(8).getFromFlight());
//        Assertions.assertEquals("Hồ Chí Minh (SGN)",
//                responseEntity.getBody().getContent().get(8).getToFlight());
//        Assertions.assertEquals(2,
//                responseEntity.getBody().getContent().get(8).getAirlineType().getId());
//        Assertions.assertEquals(true,
//                responseEntity.getBody().getContent().get(8).getAirlineType().getDelFlagAirline());
//        Assertions.assertEquals("https://static.wixstatic.com/media/9d8ed5_d3acee0b07b942d39681171e31a4ba4d~mv2.png/v1/fill/w_1339,h_838,al_c/9d8ed5_d3acee0b07b942d39681171e31a4ba4d~mv2.png",
//                responseEntity.getBody().getContent().get(8).getAirlineType().getImageAirline());
//        Assertions.assertEquals("Vietnam Airline",
//                responseEntity.getBody().getContent().get(8).getAirlineType().getNameAirline());
//        Assertions.assertEquals("2000000",
//                responseEntity.getBody().getContent().get(8).getAirlineType().getPriceAirline());

//    }
}
