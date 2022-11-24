package blog.blog_spring.Repository;

import blog.blog_spring.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class UserRepo {

    private final EntityManager em;

    UserRepo(EntityManager em) {
        this.em = em;
    }

    public User save(User user){
        Assert.notNull(user,"Entity must not be null");
        em.persist(user);

        return user;
    }

    public User update(User user){
        return em.merge(user);
    }

    //User userEntity=userRepository.findByUsername(username);
    public Optional<User> findByEmail(String email) {
        List<User> result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }
}
