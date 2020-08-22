package com.crudspringboot.repositories;

import com.crudspringboot.models.TaskModel;

import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<TaskModel, Integer> {
    
}