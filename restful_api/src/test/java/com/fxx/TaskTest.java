package com.fxx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestfulApiApplication.class)
@AutoConfigureMockMvc
public class TaskTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception{
        String list = mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(list);
    }

    @Test
    public void Insert() throws Exception {
        String InsertMessage = mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks/"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(InsertMessage);
    }

    @Test
    public void findByid() throws Exception {
        String FindMessage = mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/{id}",6))
                .andReturn().getResponse().getContentAsString();
        System.out.println(FindMessage);
    }

    @Test
    public void deleteByid() throws Exception {
        String DeleteMessage = mockMvc.perform(MockMvcRequestBuilders.delete("/api/tasks/{id}",4))
                .andReturn().getResponse().getContentAsString();
        System.out.println(DeleteMessage);
    }
}
