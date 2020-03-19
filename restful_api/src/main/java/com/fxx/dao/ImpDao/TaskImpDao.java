package com.fxx.dao.ImpDao;

import com.fxx.dao.TaskDao;
import com.fxx.domain.Task;
import com.fxx.service.TaskService;
import com.fxx.service.serviceImp.TaskServiceImpl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public class TaskImpDao implements TaskDao {
    TaskService us=new TaskServiceImpl();
    @Override
    public List<Task> findAll() {
        List<Task> allTask = us.findAllTask();
        return allTask;
    }

    @Override
    public int Insert() {
        return us.InsertTask();
    }

    @Override
    public Task findone(int num) {
        return us.findByid(num);
    }

    @Override
    public int deleteOne(int num) {
        return us.deleteByid(num);
    }
}
