package com.crudspringboot.repositories;

import com.crudspringboot.models.Task;

import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Integer> {
    
}