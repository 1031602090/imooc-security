package com.imooc.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void query() throws Exception {
        mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        String context = "{\"username\":\"zhangsan\",\"password\":\"123456\",\"date\":\""+date.getTime()+"\"}";
        String a =  mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(context))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
        .andReturn().getResponse().getContentAsString();
        System.out.println(a);
    }
    @Test
    public void whenModifySuccess() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String context = "{\"username\":\"zhangsan\",\"password\":\"123456\",\"date\":\""+date.getTime()+"\"}";
        String a =  mockMvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(context))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn().getResponse().getContentAsString();
        System.out.println(a);
    }
    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
    @Test
    public void whenFileUpload() throws Exception {
        mockMvc.perform(fileUpload("/file")
                .file(new MockMultipartFile("file",
                        "file.txt",
                        "Multipart/form-data",
                        "hello world".getBytes())))
                .andExpect(status().isOk());
    }
}