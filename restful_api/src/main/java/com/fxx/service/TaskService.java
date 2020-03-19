package com.fxx.service;

import com.fxx.domain.Task;

import java.util.List;

public interface TaskService {
    public List<Task> findAllTask();
    public int InsertTask();
    public Task findByid(int id);
    public int deleteByid(int id);
}
