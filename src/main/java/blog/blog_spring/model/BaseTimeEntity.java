package blog.blog_spring.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //다른 엔티티들이 BaseTimeEntity상속할 경우 BaseTimeEntity의 필드를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될때 시간이 자동 저장
    @Column(nullable = false)
    private LocalDate createdDate;

//    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장
//    private LocalDateTime modifiedDate;
}
