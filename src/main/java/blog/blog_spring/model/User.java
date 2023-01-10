package blog.blog_spring.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity //User 클래스가 MySQL에 테이블이 생성된다.
//@DynamicInsert //insert시에 null인 필드를 제외시켜준다.
public class User{

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    // : mysql의 경우 auto_increment 따라감
    private Long id; //시퀀스, auto_increment

    @Column(nullable = false,length=50)
    private String username;

    @Column(nullable = false,length=30)
    private String phone;

    @Column(nullable = false,length=50)
    private String nickname;

    @Column(nullable = false,length=100)
    private String password;

    @Column(nullable = false,length=50,unique = true)
    private String email;

    //DB는 RoleType이라는 게 없다.
    //@ColumnDefault("'user'") //문자라는 것을 알려줌
    //@Enumerated(EnumType.STRING)
    private String role; //Enum을 쓰는게 좋다. //ADMIN,USER
}
