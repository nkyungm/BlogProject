package blog.blog_spring.config.auth;

import blog.blog_spring.Repository.UserRepo;
import blog.blog_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername함수가 실행(규칙!!!)
@Service //IoC로 등록됨
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    //시큐리티 session(내부 Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userEntity=userRepo.findByEmail(email).get();
        if(userEntity!=null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
