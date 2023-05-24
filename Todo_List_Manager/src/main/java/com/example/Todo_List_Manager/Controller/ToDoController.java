package com.example.Todo_List_Manager.Controller;

import com.example.Todo_List_Manager.Error.TodoNotFoundException;
import com.example.Todo_List_Manager.Model.Todo;
import com.example.Todo_List_Manager.Model.User;
import com.example.Todo_List_Manager.RequestObject.GetToDoRequest;
import com.example.Todo_List_Manager.RequestObject.GetUserRequest;
import com.example.Todo_List_Manager.ResponeObject.GetToDoRespone;
import com.example.Todo_List_Manager.Service.ToDoService;
import com.example.Todo_List_Manager.Service.UserService;
import com.example.Todo_List_Manager.UpdateRequest.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("api/todos/{todoId}")
    public GetToDoRespone getTodoItemById(@PathVariable Long todoId){
        return toDoService.getItemById(todoId);
    }
    @PutMapping("/api/todos/{todoId}")
    public ResponseEntity<String> updateTodoItem(@PathVariable Long todoId, @RequestBody UpdateTodoRequest request) {
        try {
            boolean completed = request.isCompleted();
            toDoService.updateTodoItem(todoId, completed);
            return ResponseEntity.ok("Todo item updated successfully");
        } catch (TodoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/api/todos/{todoId}")
    public ResponseEntity<String> deleteTodoItem(@PathVariable Long todoId) {
        try {
            toDoService.deleteTodoItem(todoId);
            return ResponseEntity.noContent().build();
        } catch (TodoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
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
