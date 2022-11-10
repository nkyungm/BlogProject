package blog.blog_spring.Repository;

import blog.blog_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//자동으로 bean등록이 된다.
//@Repository //생략 가능하다.
public interface UserRepository extends JpaRepository<User,Long> {

}
