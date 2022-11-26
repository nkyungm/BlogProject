package blog.blog_spring.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content;

    

}
