package com.codegym.controller;

import com.codegym.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerGetListEmployee {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListEmployee_5() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.getAllEmployee(0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListEmployee_6() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.getAllEmployee(0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(15, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Huỳnh Đức Trọng",
                responseEntity.getBody().getContent().get(9).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_3_1() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("null","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_3_2() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","null","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_3_3() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","","null",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_1_1() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee(null,"","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_1_2() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("",null,"",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_1_3() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","",null,0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getEmployeeByName_2() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(15, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Huỳnh Đức Trọng",
                responseEntity.getBody().getContent().get(9).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_1() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","","@",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(15, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Huỳnh Đức Trọng",
                responseEntity.getBody().getContent().get(9).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_2() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","001","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(9, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Đặng Huy Hoàng",
                responseEntity.getBody().getContent().get(8).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_3() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("h","","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Hoàng Thị Hậu",
                responseEntity.getBody().getContent().get(9).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_4() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("h","001","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(7, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Đặng Huy Hoàng",
                responseEntity.getBody().getContent().get(6).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_5() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("h","","@",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(13, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Hoàng Thị Hậu",
                responseEntity.getBody().getContent().get(9).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_6() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("","001","@",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(9, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Đặng Huy Hoàng",
                responseEntity.getBody().getContent().get(8).getNameEmployee());
    }

    @Test
    public void getEmployeeByName_4_7() {
        ResponseEntity<Page<Employee>> responseEntity = this.employeeController.findEmployee("Quốc Phú","001","@",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Hoàng Đặng Quốc Phú",
                responseEntity.getBody().getContent().get(0).getNameEmployee());
    }

    @Test
    public void deleteEmployee_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/delete/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/employee/delete/{id}", "99"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/employee/delete/{id}", "10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
