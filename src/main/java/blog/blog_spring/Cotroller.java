package blog.blog_spring;

import blog.blog_spring.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cotroller {

    //http://localhost:8000/blog/dummy/join (요청)
    //http의 body에 username,password,email,phone,nickname 데이터 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("id: "+user.getId());
        System.out.println("username: "+user.getUsername());
        System.out.println("phone: "+user.getPhone());
        System.out.println("nickname: "+user.getNickname());
        System.out.println("password: "+user.getPassword());
        System.out.println("email: "+user.getEmail());
        System.out.println("role: "+user.getRole());
        System.out.println("createDate: "+user.getCreateDate());
        return "회원가입이 완료되었습니다.";
    }
}
