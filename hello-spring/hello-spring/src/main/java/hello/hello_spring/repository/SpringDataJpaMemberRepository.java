package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스는 다중 상속이 가능하다. 인터페이스가 인터페이스를 받을 때는  extends 이다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //jpaRepo 사용해서 memberRepo 구현체를 만들어 빈에 저장. 즉 config 에서 주입받을 수 있다.
    @Override
    Optional<Member> findByName(String name);
}

