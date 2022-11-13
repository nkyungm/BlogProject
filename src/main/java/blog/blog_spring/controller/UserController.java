package blog.blog_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/blog/user/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }
}
