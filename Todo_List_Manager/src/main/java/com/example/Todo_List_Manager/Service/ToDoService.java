package com.example.Todo_List_Manager.Service;

import com.example.Todo_List_Manager.Model.Todo;
import com.example.Todo_List_Manager.Model.User;
import com.example.Todo_List_Manager.Repository.ToDoRepository;
import com.example.Todo_List_Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;
    public void addItems(Todo todo) {
        toDoRepository.save(todo);
    }
}
