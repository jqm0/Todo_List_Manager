package com.example.Todo_List_Manager.Service;

import com.example.Todo_List_Manager.Error.UserRegistrationException;
import com.example.Todo_List_Manager.Model.User;
import com.example.Todo_List_Manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
     UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password) {

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userRepository.save(user);
    }
    public User getUserById(Long userId) {
        return null;

    }

    public List<User> getAllUsers() {
        return null;

    }

    public void updateUser(User user) {

    }
    public void deleteUser(Long userId) {

    }


}
