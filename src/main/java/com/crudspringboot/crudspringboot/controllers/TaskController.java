package com.crudspringboot.crudspringboot.controllers;

import java.util.ArrayList;

import com.crudspringboot.crudspringboot.services.TaskService;
import com.crudspringboot.crudspringboot.models.TaskModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        ArrayList<TaskModel> tasks = this.service.getTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/newTask")
    public String newTask(Model model){
        model.addAttribute("task", new TaskModel());        
        return "form";
    }

    @PostMapping("/saveTask")
    public String addTask(TaskModel task, Model model){
        service.createTask(task);       
        return "redirect:/tasks";
    }
}