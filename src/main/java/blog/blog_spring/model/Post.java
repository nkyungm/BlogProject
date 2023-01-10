package blog.blog_spring.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 500)
    private String title;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content;

//    @Temporal(TemporalType.DATE) //날짜 타입 매핑
//    @Column(nullable = false)
//    private Date create_dt;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="blog_id",nullable = false)
    private Blog blog;

    @Column(nullable = false)
    private Long like_cnt;


}
