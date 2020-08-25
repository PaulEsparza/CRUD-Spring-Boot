package com.crudspringboot.crudspringboot.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.crudspringboot.crudspringboot.services.TaskService;
import com.crudspringboot.crudspringboot.models.TaskModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService service;

    public boolean editing, reading;

    @GetMapping("/")
    public String getTasks(Model model) {
        ArrayList<TaskModel> tasks = this.service.getTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    //@GetMapping("/newTask")
    @RequestMapping(value = "/newTask", method = RequestMethod.GET)
    public String newTask(Model model){
        model.addAttribute("task", new TaskModel());
        this.editing = false;
        model.addAttribute("editing", this.editing); 
        this.reading = false;
        model.addAttribute("reading", this.reading);       
        return "form";
    }

    @PostMapping("/saveTask")
    public void addTask(TaskModel task, Model model, HttpServletResponse response) throws IOException{
        service.createTask(task);       
        //return "redirect:/tasks";
        response.sendRedirect("/");
    }

    @GetMapping("/readTask/{id}")
    public String readTask(@PathVariable int id, Model model){
        Optional<TaskModel> task = service.getTaskId(id); 
        model.addAttribute("task", task);
        this.reading = true;
        model.addAttribute("reading", this.reading);      
        return "form";
    }

    @GetMapping("/editTask/{id}")
    public String editTask(@PathVariable int id, Model model){
        Optional<TaskModel> task = service.getTaskId(id); 
        model.addAttribute("task", task);
        this.editing = true;
        model.addAttribute("editing", this.editing);     
        this.reading = false;
        model.addAttribute("reading", this.reading); 
        return "form";
    }

    @GetMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable int id, Model model, HttpServletResponse response) throws IOException {
        service.deleteTask(id);       
        //return "redirect:/tasks";
        response.sendRedirect("/");
    }
}