package com.crudspringboot.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    @Column(name = "responsable", nullable = false)
    private String responsable;

    @Basic(optional = false)
    @Column(name = "description", nullable = false)
    private String description;

    public Task(){

    }

    public Task(int id, String responsable, String description){
        this.id = id;
        this.responsable = responsable;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getResponsable(){
        return this.responsable;
    }

    public void setResponsable(String responsable){
        this.responsable = responsable;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}