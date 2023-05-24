package com.example.Todo_List_Manager.RequestObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetToDoRequest {
    String title ;
    String description ;
    boolean completed;

}
