package cn.exiafor.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RESTController {
    @GetMapping("/t/{id}/{username}")
    public String getMethod(@PathVariable("id") String id,
                            @PathVariable("username") String username) {

        System.out.println("id = " + id + "\nusername = " + username);

        return "id = " + id + "\nusername = " + username;
    }

    @PostMapping("/t")
    public String postMethod() {
        return "postMethod()";
    }

    @DeleteMapping("/t")
    public String deleteMethod() {
        return "deleteMethod()";
    }

    @PutMapping("/t")
    public String putMethod() {
        return "putMethod()";
    }
}
