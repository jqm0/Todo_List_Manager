package com.example.Todo_List_Manager.Controller;

import com.example.Todo_List_Manager.Error.UserRegistrationException;
import com.example.Todo_List_Manager.Model.User;
import com.example.Todo_List_Manager.RequestObject.GetUserRequest;
import com.example.Todo_List_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("api/register")
    public ResponseEntity<Void> saveAccount (@RequestBody GetUserRequest userRequestObject) {
            createUser(userRequestObject);
            return ResponseEntity.ok().build();

    }
    public void createUser(GetUserRequest getUserRequest){
        User user = new User();
        user.setName(getUserRequest.getUserName());
        user.setPassword(getUserRequest.getPassword());
        user.setIsActive(true);
        user.setCreatedDate(new Date());
        userService.registerUser(user);

    }


}






