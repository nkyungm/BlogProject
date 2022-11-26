package blog.blog_spring.model;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Blog {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(nullable = false)
    private String blogname;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
