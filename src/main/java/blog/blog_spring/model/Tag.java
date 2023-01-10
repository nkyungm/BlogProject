package blog.blog_spring.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tag_name;

    @ManyToOne
    @JoinColumn(name="post_id",nullable = false)
    private Post post;
}