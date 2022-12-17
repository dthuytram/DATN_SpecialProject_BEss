package com.codegym.controller;

import com.codegym.dto.NewsDto;
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
public class PostCreateNews {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createNews_code_news()throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(null);
        newsDto.setCodeNews("TT-0001");
        newsDto.setDateNews("2000-12-12");
        newsDto.setDescriptionNews("Lắng nghe chiều xuống thành phố mộng mơ.");
        newsDto.setImageNews("https://focusasiatravel.vn/wp-content/uploads/2020/07/ngam-hoang-hon-da-lat.jpg");
        newsDto.setNameNews("Ba con sâu");
        newsDto.setTitleNews("Hoàng hôn ở đà lạt");
        newsDto.setDelFlagNews(null);
        newsDto.setCategory(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/news/create")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createNews_code_news_one()throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(null);
        newsDto.setCodeNews(null);
        newsDto.setDateNews(null);
        newsDto.setDescriptionNews(null);
        newsDto.setImageNews(null);
        newsDto.setNameNews(null);
        newsDto.setTitleNews(null);
        newsDto.setDelFlagNews(null);
        newsDto.setCategory(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/news/create")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createNews_code_news_two()throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(null);
        newsDto.setCodeNews("");
        newsDto.setDateNews("");
        newsDto.setDescriptionNews("");
        newsDto.setImageNews("");
        newsDto.setNameNews("");
        newsDto.setTitleNews("");
        newsDto.setDelFlagNews(null);
        newsDto.setCategory(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/news/create")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createNews_code_news_three()throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(null);
        newsDto.setCodeNews("TT-12");
        newsDto.setDateNews("2000-12-12");
        newsDto.setDescriptionNews("Lắng nghe chiều xuống thành phố mộng mơ.");
        newsDto.setImageNews("https://focusasiatravel.vn/wp-content/uploads/2020/07/ngam-hoang-hon-da-lat.jpg");
        newsDto.setNameNews("a");
        newsDto.setTitleNews("Hoàng hôn ở đà lạt");
        newsDto.setDelFlagNews(null);
        newsDto.setCategory(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/news/create")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createNews_code_news_four()throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(1L);
        newsDto.setCodeNews("TT-0001");
        newsDto.setDateNews("2000-12-12");
        newsDto.setDescriptionNews("“Lắng nghe chiều xuống thành phố mộng mơ.");
        newsDto.setImageNews("https://focusasiatravel.vn/wp-content/uploads/2020/07/ngam-hoang-hon-da-lat.jpg");
        newsDto.setNameNews("Ba con sâu");
        newsDto.setTitleNews("Hoàng hôn ở đà lạt");
        newsDto.setDelFlagNews(true);
        newsDto.setCategory(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/news/create")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
