package blog.blog_spring.service;

import blog.blog_spring.Repository.JpaBlogRepository;
import blog.blog_spring.model.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false) //read-Only 오류 나는 경우 readOnly=false로 변경하기
@RequiredArgsConstructor
public class BlogService {

    private final JpaBlogRepository jpaBlogRepository;

    public Blog createBlog(Blog blog){
        return jpaBlogRepository.save(blog);
    }

    public List<Blog> findBlog(Long id){ //자신의 블로그 조회
        return jpaBlogRepository.findByUserid(id);
    }

}
