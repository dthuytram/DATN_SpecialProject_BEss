package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
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
public class EmployeeRestController_createEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_name_35_null() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail_Employee("duongcongminhson@gmail.com");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("26-02-1998");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_name_35() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("");
        employeeDto.setEmail_Employee("duongcongminhson@gmail.com");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_name_35_success() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("Son Duong Cong Minh");
        employeeDto.setEmail_Employee("duongcongminhson@gmail.com");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void createEmployee_email_35_null() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("Son Duong Cong Minh");
        employeeDto.setEmail_Employee(null);
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_35_blank() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("Son Duong Cong Minh");
        employeeDto.setEmail_Employee("");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_35_wrong_format() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("Son Duong Cong Minh");
        employeeDto.setEmail_Employee("abc.com");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_email_35_success() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName_Employee("Son Duong Cong Minh");
        employeeDto.setEmail_Employee("duongcongminhson@gmail.com");
        employeeDto.setCode_Employee("NV-001");
        employeeDto.setGender_Employee(true);
        employeeDto.setBirthday_Employee("1998-02-26");
        employeeDto.setPhone_Employee("0363078878");
        employeeDto.setAddress_Employee("Thừa thiên huế");
        employeeDto.setId_Employee_Type(2L);
        employeeDto.setDel_Flag_Employee(true);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/createEmployee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
