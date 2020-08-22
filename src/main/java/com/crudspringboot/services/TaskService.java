package com.crudspringboot.services;

import java.util.ArrayList;
import java.util.Optional;

import com.crudspringboot.interfaceService.ITaskService;
import com.crudspringboot.models.TaskModel;
import com.crudspringboot.repositories.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository repo;

    @Override
    public ArrayList<TaskModel> getTasks() {
        return (ArrayList<TaskModel>) this.repo.findAll();
    }

    @Override
    public Optional<TaskModel> getTaskId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskModel createTask(TaskModel task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteTask(int id) {
        // TODO Auto-generated method stub

    }
    
}