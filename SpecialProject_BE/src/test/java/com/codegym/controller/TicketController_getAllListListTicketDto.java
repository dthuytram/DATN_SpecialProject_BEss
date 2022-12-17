//package com.codegym.controller;
//
//import com.codegym.controller.TicketController;
//import com.codegym.model.Ticket;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class TicketController_getAllListListTicketDto {
//
//    @Autowired
//    private TicketController ticketController;
//
//    @Test
//    public void getAllListTicket_5() {
//        ResponseEntity<Page<Ticket>> responseEntity
//                = this.ticketController.getAllListTicket(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void getListStudent_6() {
//        ResponseEntity<Page<Ticket>> responseEntity
//                = this.ticketController.getAllListTicket(PageRequest.of(0, 10));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//}
