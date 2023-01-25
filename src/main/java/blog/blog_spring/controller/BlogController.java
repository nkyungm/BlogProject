package blog.blog_spring.controller;

import blog.blog_spring.model.Blog;
import blog.blog_spring.model.User;
import blog.blog_spring.service.BlogService;
import blog.blog_spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final UserService userService;

    @GetMapping("/userblog")
    public String blogForm(){
        return "user/BlogForm";}

    @PostMapping("/blog")
    public String createBlog(Blog blog){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String useremail = ((UserDetails)principal).getUsername();
        Optional<User> user=userService.findByEmail(useremail);
        User user1 = user.get();
        blog.setUser(user1);
        blogService.createBlog(blog);
        return "redirect:/user";
    }

    @GetMapping("/blogs")
    public String blogs(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String useremail = ((UserDetails)principal).getUsername();
        Optional<User> user=userService.findByEmail(useremail);
        Long userid=user.get().getId();
        List<Blog> blogList=blogService.findBlog(userid);

        model.addAttribute("blogList",blogList);
        return "user/Blogs";
    }
}
