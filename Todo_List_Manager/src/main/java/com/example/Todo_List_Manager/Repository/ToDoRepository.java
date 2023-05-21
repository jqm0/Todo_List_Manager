package com.example.Todo_List_Manager.Repository;

import com.example.Todo_List_Manager.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Long> {
}
