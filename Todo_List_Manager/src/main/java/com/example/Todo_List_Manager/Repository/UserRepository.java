package com.example.Todo_List_Manager.Repository;

import com.example.Todo_List_Manager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
