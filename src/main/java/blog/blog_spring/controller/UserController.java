package blog.blog_spring.controller;

import blog.blog_spring.Repository.UserRepo;
import blog.blog_spring.Repository.UserRepository;
import blog.blog_spring.model.RoleType;
import blog.blog_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //View를 리턴하겠다
public class UserController {

    @Autowired //의존성 주입(DI)
    //private UserRepository userRepository;
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //비밀번호 암호화

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }
    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword=user.getPassword();
        String encPassword=bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepo.save(user); //회원가입이 잘됨. 비밀번호:1234 => 시큐리티로 로그인을 할 수 없음. 이유는 패스워드가 암호화가 안되었기 때문

        return "redirect:/loginForm"; //redirect를 붙이면 위의 loginForm 함수로 이동
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')") //권한 여러개 걸고 싶을때 사용, 함수 실행전에 동작
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터정보";
    }

}
