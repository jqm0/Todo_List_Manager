package com.example.Todo_List_Manager.ResponeObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetToDoRespone {
    String title ;
    String description ;
    boolean completed;
}
