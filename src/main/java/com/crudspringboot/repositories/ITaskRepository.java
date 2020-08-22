package com.crudspringboot.repositories;

import com.crudspringboot.models.TaskModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ITaskRepository extends CrudRepository<TaskModel, Integer> {
    
}