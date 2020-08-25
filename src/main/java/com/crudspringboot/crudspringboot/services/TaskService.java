package com.crudspringboot.crudspringboot.services;

import java.util.ArrayList;
import java.util.Optional;

import com.crudspringboot.crudspringboot.interfaceService.ITaskService;
import com.crudspringboot.crudspringboot.models.TaskModel;
import com.crudspringboot.crudspringboot.repositories.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository repo;

    @Override
    public ArrayList<TaskModel> getTasks() {
        return (ArrayList<TaskModel>) this.repo.findAll();
    }

    @Override
    public Optional<TaskModel> getTaskId(int id) {
        return this.repo.findById(id);
    }

    @Override
    public TaskModel createTask(TaskModel task) {
        //int res = 0;
        TaskModel t = repo.save(task);
        return t;
    }

    @Override
    public void deleteTask(int id) {
        repo.deleteById(id);
    }
    
}