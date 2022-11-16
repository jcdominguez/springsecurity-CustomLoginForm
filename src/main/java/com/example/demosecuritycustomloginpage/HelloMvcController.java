package com.example.demosecuritycustomloginpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloMvcController {

    @GetMapping("hello")
    public String sayHello(){
        return "hello.html";
    }

    @GetMapping("mylogin")
    public String myCustomLoginForm(){
        return "mylogin.html";
    }
}
