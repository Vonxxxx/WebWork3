package com.fxx.service.serviceImp;

import com.fxx.domain.Task;
import com.fxx.service.TaskService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override

    public List<Task> findAllTask() {
        String sql = "SELECT * FROM task";
        //返回list集合，需要我们自己实现RowMapper接口，从结果集里得到数据
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Task.class));
    }

    @Override
    public int InsertTask() {
        String sql = "INSERT INTO task(content,createdTime) VALUES(?,?)";
        Task task=new Task();
        task.setContent("Restful API homework");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(new Date());
        task.setCreatedTime(s);
        int update = jdbcTemplate.update(sql, task.getContent(),task.getCreatedTime());
        return update;
    }

    @Override
    public Task findByid(int id) {
        String sql = "SELECT * FROM task where id=?";
        List query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Task.class),id);
        if(query.size()==0){
            return null;
        }else {
            return (Task) query.get(0);
        }
    }

    @Override
    public int deleteByid(int id) {
        String sql = "Delete FROM task where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }
}
