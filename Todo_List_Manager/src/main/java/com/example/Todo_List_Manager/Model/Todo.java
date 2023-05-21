package com.example.Todo_List_Manager.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

  
}
