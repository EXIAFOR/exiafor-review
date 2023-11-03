package cn.exiafor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String handle01() {
        return "Hello, Spring Boot 2 !\n你好！Spring Boot 2 !";
    }
}
