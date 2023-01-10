package blog.blog_spring.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;
}
