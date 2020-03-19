package com.fxx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxx.domain.Task;
import com.fxx.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value="/api/tasks/")
    public String getMapping() throws Exception {
        List<Task> all = taskService.findAllTask();
        ObjectMapper om=new ObjectMapper();
        String s = om.writeValueAsString(all);
        return s;
//        return "this is gettest";
    }

    @PostMapping(value="/api/tasks/")
    public String postMapping() {
        int i = taskService.InsertTask();
        return "插入成功，插入条数："+i;
//        return "this is inserttest";
    }

    @GetMapping(value="/api/tasks/{id}")
    public String getMapping(@PathVariable int id) throws Exception {
        Task byid = taskService.findByid(id);
        if(byid==null)
            return "不存在该id用户！";
        else{
            ObjectMapper om=new ObjectMapper();
            String jsonbyid = om.writeValueAsString(byid);
            return jsonbyid;
        }
//        return "this is getonetest";
    }

    @DeleteMapping(value="/api/tasks/{id}")
    public String DeleteMapping(@PathVariable int id) {
        int i = taskService.deleteByid(id);
        return i!=0?"成功删除id="+id+"的用户" : "id="+id+"的用户不存在";
//        return "this is deletetest";
    }
}
