package blog.blog_spring.Repository;

import blog.blog_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//자동으로 bean등록이 된다.
//@Repository라는 어노테이션이 없어도 IoC된다. 이유는 JpaRepository를 상속했기 때문에
//CRUD 함수를 JpaRepository가 들고있음
public interface UserRepository {
    //findBy 규칙 -> Username 문법 //JPA 쿼리 메소드
    //select * from user where username= ?

    //public User findByUsername(String username);

}
