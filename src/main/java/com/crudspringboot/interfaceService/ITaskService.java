package com.crudspringboot.interfaceService;

import java.util.ArrayList;
import java.util.Optional;

import com.crudspringboot.models.TaskModel;

public interface ITaskService {
    
    public ArrayList<TaskModel> getTasks();
    public Optional<TaskModel> getTaskId(int id);
    public TaskModel createTask(TaskModel task);
    public void deleteTask(int id);
}