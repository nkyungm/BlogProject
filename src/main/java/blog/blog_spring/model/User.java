package blog.blog_spring.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity //User 클래스가 MySQL에 테이블이 생성된다.
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    // : mysql의 경우 auto_increment 따라감
    private Long id; //시퀀스, auto_increment

    @Column(nullable = false,length=30)
    private String username;

    @Column(nullable = false,length=14)
    private String phone;

    @Column(nullable = false,length=30)
    private String nickname;

    @Column(nullable = false,length=100)
    private String password;

    @Column(nullable = false,length=50)
    private String email;

    @ColumnDefault("'user'") //문자라는 것을 알려줌
    private String role; //Enum을 쓰는게 좋다. //admin,user,manager

    @CreationTimestamp //시간이 자동으로 입력됨
    private Timestamp createDate;
}