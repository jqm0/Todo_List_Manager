package com.example.Todo_List_Manager.Service;

import com.example.Todo_List_Manager.Error.TodoNotFoundException;
import com.example.Todo_List_Manager.Model.Todo;

import com.example.Todo_List_Manager.Repository.ToDoRepository;
import com.example.Todo_List_Manager.ResponeObject.GetToDoRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;
    // --------------- adding new item to todo list ----------------
    public void addItems(Todo todo) {
        toDoRepository.save(todo);
    }
    ///  ---------- fetching and getting data from DB --------
    public List<Todo> getTodo(){
        return toDoRepository.findAll();
    }
    public GetToDoRespone getItemById(Long accountId) {
        Optional<Todo> optionalAccount =  toDoRepository.findById(accountId);
        if(!optionalAccount.isEmpty())
        {
            Todo todo =  optionalAccount.get();
            GetToDoRespone accountResponse = new GetToDoRespone(todo.getTitle(),todo.getDescription(),todo.getCompleted());
            return accountResponse;
        }


        return null;

    }
    // ------------------- update TodoItem (Status) ------------------
    public void updateTodoItem(Long todoId, boolean completed) {
        Optional<Todo> optionalTodo = toDoRepository.findById(todoId);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setCompleted(completed);
            toDoRepository.save(todo);
        } else {
            throw new TodoNotFoundException("Todo item not found with ID: " + todoId);
        }
    }
    // -------------- delete an item from todo list by its ID --------
    public void deleteTodoItem(Long todoId) {
        Optional<Todo> optionalTodo = toDoRepository.findById(todoId);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            toDoRepository.delete(todo);
        } else {
            throw new TodoNotFoundException("Todo item not found with ID: " + todoId);
        }
    }
}

