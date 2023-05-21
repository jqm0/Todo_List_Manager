package com.example.Todo_List_Manager.Controller;

import com.example.Todo_List_Manager.Model.Todo;
import com.example.Todo_List_Manager.Model.User;
import com.example.Todo_List_Manager.RequestObject.GetToDoRequest;
import com.example.Todo_List_Manager.RequestObject.GetUserRequest;
import com.example.Todo_List_Manager.Service.ToDoService;
import com.example.Todo_List_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    ToDoService toDoService;
    @PostMapping("/api/todos")
    public ResponseEntity<Void> saveAccount (@RequestBody GetToDoRequest getToDoRequest) {
        createTodoItem(getToDoRequest);
        return ResponseEntity.ok().build();

    }
    public void createTodoItem(){}
    public void getAllTodoItems(){}
    public void getTodoItemById(){}
    public void updateTodoItem(){}
    public void deleteTodoItem(){}
    public void createTodoItem(GetToDoRequest getToDoRequest){
        Todo todo = new Todo();
        todo.setTitle(getToDoRequest.getTitle());
        todo.setDescription(getToDoRequest.getDescription());
        todo.setCompleted(false);
        todo.setIsActive(true);
        todo.setCreatedDate(new Date());
        toDoService.addItems(todo);

    }
    @GetMapping("api/todos")
    public List<Todo> getTodos () {
        return toDoService.getTodo();
    }
}
