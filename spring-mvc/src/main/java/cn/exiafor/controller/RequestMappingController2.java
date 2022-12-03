package cn.exiafor.controller;

import cn.exiafor.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RequestMappingController2 {
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username", "password!=123456"}
    )
    public String testRequestMapping() {
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(
            @PathVariable("id") String id,
            @PathVariable("username") String username
    ) {
        System.out.println("--> id : " + id + "\n--> username : " + username);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("username : " + username + "\npassword : " + password);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testPOJO(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /*
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("testScope", "hello,ModelAndView");
        //设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello,Model");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/hello";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/hello";
    }
}
