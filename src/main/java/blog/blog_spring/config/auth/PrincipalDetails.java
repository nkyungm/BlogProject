package blog.blog_spring.config.auth;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인을 진행이 완료가 되면 시큐리티 session을 만들어줍니다.(Security ContextHolder)
//오브젝트 => Authentication 타입 객체
//Authentication 안에 User정보가 있어야 됨.
//User 오브젝트 타입 => UserDetails 타입 객체

//시큐리티 Session => Authentication => UserDetails(PrincipalDetails)

import blog.blog_spring.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private User user; //콤포지션

    public PrincipalDetails(User user){ //생성자
        this.user=user;
    }

    //해당 User의 권한을 리턴하는곳!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect=new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { //계정 만료
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정 잠김
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 1년 지났나
        return true;
    }

    @Override
    public boolean isEnabled() { //활성화
        //우리 사이트에서 1년동안 회원이 로그인을 안하면 휴먼 계정으로 하기로함
        //현재시간 - 로그인시간 => 1년을 초과하면 return false;
        return true;
    }
}
