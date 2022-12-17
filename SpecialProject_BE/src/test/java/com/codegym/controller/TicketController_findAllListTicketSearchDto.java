//package com.codegym.controller;
//

//

//import com.codegym.dto.ListTicketDto;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class TicketController_findAllListTicketSearchDto {
//
//    @Autowired
//    private TicketController ticketController;
//
//    @Test
//    public void findAllTicket_1_1() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch(null, "", "", 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllTicket_1_2() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("", null, "", 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllTicket_1_3() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("", "", null, 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//
//    @Test
//    public void findAllTicket_2() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("", "", "", 0);
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Hoàng Phước Tịnh",
//                responseEntity.getBody().getContent().get(1).getBuyerTicket());
//    }
//
//    @Test
//    public void findAllTicket_3_1() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch(null, "", "", 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllTicket_3_2() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("", null, "", 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllTicket_3_3() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("", "", null, 0);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllTicket_4_1() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","@",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//    @Test
//    public void findAllTicket_4_2() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","002","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//    @Test
//    public void findAllTicket_4_3() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//
//    @Test
//    public void findAllTicket_4_4() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//    @Test
//    public void findAllTicket_4_5() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//    @Test
//    public void findAllTicket_4_6() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//
//    @Test
//    public void findAllTicket_4_7() {
//        ResponseEntity<Page<ListTicketDto>> responseEntity = this.ticketController.findAllTicketSearch("","","",0);
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TK-002",
//                responseEntity.getBody().getContent().get(1).getCodeTicket());
//    }
//}
