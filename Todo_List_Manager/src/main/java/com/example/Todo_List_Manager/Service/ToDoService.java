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
    public void addItems(Todo todo) {
        toDoRepository.save(todo);
    }
    public List<Todo> getTodo(){
        return toDoRepository.findAll();
    }
    public GetToDoRespone getItemById(Long accountId) {
        Optional<Todo> optionalAccount =  toDoRepository.findById(accountId);
        if(!optionalAccount.isEmpty())
        {
            Todo todo =  optionalAccount.get();
            GetToDoRespone accountResponse = new GetToDoRespone(todo.getTitle(),todo.getDescription());
            return accountResponse;
        }


        return null;

    }
    public void updateTodoItem(Long todoId, boolean completed) {
        Optional<Todo> optionalTodoItem = toDoRepository.findById(todoId);
        if (optionalTodoItem.isPresent()) {
            Todo todoItem = optionalTodoItem.get();
            todoItem.setCompleted(completed);
            // You can update other properties of the todo item as needed

            toDoRepository.save(todoItem);
        } else {
            throw new TodoNotFoundException("Todo item not found with ID: " + todoId);
        }
    }
}
