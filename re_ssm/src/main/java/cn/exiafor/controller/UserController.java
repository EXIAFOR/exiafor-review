package cn.exiafor.controller;

import cn.exiafor.service.UserService;
import org.springframework.stereotype.Controller;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }
}
