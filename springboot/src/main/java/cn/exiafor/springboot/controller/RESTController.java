package cn.exiafor.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }

    @PutMapping("/user")
    public String updateUser(){
        return "PUT-张三";
    }

    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }
}
