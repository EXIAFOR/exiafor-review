package cn.exiafor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
    @GetMapping("/h")
    public String hello(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("req.getCharacterEncoding() : " + req.getCharacterEncoding());
        System.out.println("resp.getCharacterEncoding() : " + resp.getCharacterEncoding());
        System.out.println("请求进入到服务器");
        return "fbiusadfbuidsbfiudsbfiudsf-中文就会乱码";
    }
}
