package com.example.Todo_List_Manager.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Data
public class UserRegistrationDto {
    String userName ;
    String password ;
}
