package com.fxx.dao;

import com.fxx.domain.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface TaskDao {
    public List<Task> findAll();
    public int Insert();
    public Task findone(int num);
    public int deleteOne(int num);
}
