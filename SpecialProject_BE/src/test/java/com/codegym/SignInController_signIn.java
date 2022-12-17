package com.codegym;

import com.codegym.controller.SignInController;
import com.codegym.model.User;
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
public class SignInController_signIn {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SignInController signInController;
    @Autowired
    ObjectMapper objectMapper;
    User user = new User("myemail@gmail.com","123");

    @Test
    public void signUp_email_13() throws Exception {
        user.setEmail(null);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/signUp",signForm))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_email_14() throws Exception {
        user.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_email_15() throws Exception {
        user.setEmail("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //16,17 phan email SRS khong yeu cau

    @Test
    public void signUp_email_18() throws Exception {
        user.setEmail("new@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void signUp_password_13() throws Exception {
        user.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_password_14() throws Exception {
        user.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_passWord_15() throws Exception {
        user.setPassword("aaabbbbbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_passWord_16() throws Exception {
        user.setPassword("aaa4444");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_passWord_17() throws Exception {
        user.setPassword("aaabbbbbbbbbbbbbbbbbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_password_18() throws Exception {
        user.setPassword("abcABC123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
