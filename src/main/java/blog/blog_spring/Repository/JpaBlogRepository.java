package blog.blog_spring.Repository;

import blog.blog_spring.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaBlogRepository{

    private final EntityManager em;

    public JpaBlogRepository(EntityManager em) {
        this.em = em;
    }

    public Blog save(Blog blog) {
        em.persist(blog);
        return blog;
    }

    public Optional<Blog> findById(Long id) {
        Blog blog=em.find(Blog.class,id);
        return Optional.ofNullable(blog);
    }

    public List<Blog> findByUserid(Long id) {
        return em.createQuery("select b from Blog b where b.user.id=:id",Blog.class)
                .setParameter("id",id)
                .getResultList();
    }

    public List<Blog> findAll() {
        return em.createQuery("select b from Blog b",Blog.class)
                .getResultList();
    }
}


