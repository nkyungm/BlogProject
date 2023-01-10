package blog.blog_spring.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Command extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "TINYTEXT")
    private String content;

//    @Temporal(TemporalType.DATE) //날짜 타입 매핑
//    @Column(nullable = false)
//    private Date create_dt;

    @ManyToOne
    @JoinColumn(name="post_id",nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
