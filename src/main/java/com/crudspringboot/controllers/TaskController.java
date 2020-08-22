package com.crudspringboot.controllers;

import java.util.ArrayList;

import com.crudspringboot.models.TaskModel;
import com.crudspringboot.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping()
    public String getTasks(Model model) {
        ArrayList<TaskModel> tasks = this.service.getTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}