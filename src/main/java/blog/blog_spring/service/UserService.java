package blog.blog_spring.service;
import blog.blog_spring.Repository.UserRepo;
import blog.blog_spring.model.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@Transactional(readOnly = false) //read-Only 오류 나는 경우 readOnly=false로 변경하기
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User save(User user){
        return userRepo.save(user);
    }

    public User update(User user){
        return userRepo.update(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

}
