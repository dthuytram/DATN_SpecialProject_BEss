package com.codegym;

import com.codegym.controller.SignInController;
import com.codegym.model.Countries;
import com.codegym.model.SignForm;
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
public class SignInController_signUp {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SignInController signInController;
    @Autowired
    ObjectMapper objectMapper;
    SignForm signForm = new SignForm(null,"999999999","999999999",
            "0911111111","LeAnhTuan Anh","2011-12-12","DN",true,
            "111111111111",new Countries(1L,"Viet Nam"));
    @Test
    public void signUp_email_13() throws Exception {
       signForm.setEmail(null);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/signUp",signForm))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_email_14() throws Exception {
        signForm.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_email_15() throws Exception {
        signForm.setEmail("aaa");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //16,17 phan email SRS khong yeu cau

    @Test
    public void signUp_email_18() throws Exception {
        signForm.setEmail("new@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void signUp_password_13() throws Exception {
        signForm.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_password_14() throws Exception {
        signForm.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_passWord_15() throws Exception {
        signForm.setPassword("aaabbbbbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_passWord_16() throws Exception {
        signForm.setPassword("aaa4444");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_passWord_17() throws Exception {
        signForm.setPassword("aaabbbbbbbbbbbbbbbbbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_password_18() throws Exception {
        signForm.setPassword("abcABC123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    //13,14,16,17 phan confirmPassword file SRS khong yeu cau

    @Test
    public void signUp_confirmPassword_15() throws Exception {
        signForm.setConfirmPassword("abcABC123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_confirmPassword_18() throws Exception {
        signForm.setConfirmPassword("abcABC123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void signUp_phone_13() throws Exception {
        signForm.setPhone(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_phone_14() throws Exception {
        signForm.setPhone("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void signUp_phone_15() throws Exception {
        signForm.setPhone("090111111");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //16,17 phan phone file srs khong yeu cau

    @Test
    public void signUp_phone_18() throws Exception {
        signForm.setPhone("0912345678");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




    @Test
    public void signUp_fullName_13() throws Exception {
        signForm.setFullName(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_fullName_14() throws Exception {
        signForm.setFullName("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_fullName_15() throws Exception {
        signForm.setFullName("ab 0000");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_fullName_16() throws Exception {
        signForm.setFullName("LeNguyen");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_fullName_17() throws Exception {
        signForm.setFullName("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_fullName_18() throws Exception {
        signForm.setFullName("LeDoTranNguyen");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



    @Test
    public void signUp_birthday_13() throws Exception {
        signForm.setBirthday(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_birthday_14() throws Exception {
        signForm.setBirthday("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_birthday_15() throws Exception {
        signForm.setBirthday("ab 0000");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_birthday_16() throws Exception {
        signForm.setBirthday("2006-12-12");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_birthday_17() throws Exception {
        signForm.setBirthday("1850-02-02");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_birthday_18() throws Exception {
        signForm.setBirthday("1995-02-02");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    //address,gender file SRS khong yeu cau validate

    @Test
    public void signUp_idCard_13() throws Exception {
        signForm.setIdCard(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_idCard_14() throws Exception {
        signForm.setIdCard("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_setIdcard_15() throws Exception {
        signForm.setIdCard("ab 0000");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_idCard_16() throws Exception {
        signForm.setIdCard("7777777");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_idCard_17() throws Exception {
        signForm.setIdCard("11111111111111");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_idCard_18() throws Exception {
        signForm.setFullName("111111111111");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //country la object, xuat hien trong select nen chi co truong hop null va co co gia tri
    @Test
    public void signUp_country_13() throws Exception {
        signForm.setCountry(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_country_18() throws Exception {
        signForm.setCountry(new Countries(1L,"VietNam"));
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

