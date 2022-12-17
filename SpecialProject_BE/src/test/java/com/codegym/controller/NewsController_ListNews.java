package com.codegym.controller;

import com.codegym.model.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class NewsController_ListNews {

//    @Autowired
//    private NewsController newsController;
//
//    @Test
//    public void findAllNews_1() {
//        ResponseEntity<Page<News>> pageResponseEntity = this.newsController.findAllNews(PageRequest.of(0, 10));
//        Assertions.assertEquals(404, pageResponseEntity.getStatusCodeValue());
//
//    }
//
//    @Test
//    public void findAllNews_2() {
//        ResponseEntity<Page<News>> responseEntity = this.newsController.findAllNews(PageRequest.of(0, 10));
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(7, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("TT-0007",
//                responseEntity.getBody().getContent().get(6).getCodeNews());
//        Assertions.assertEquals("Hiếu",
//                responseEntity.getBody().getContent().get(6).getNameNews());
//    }


}
