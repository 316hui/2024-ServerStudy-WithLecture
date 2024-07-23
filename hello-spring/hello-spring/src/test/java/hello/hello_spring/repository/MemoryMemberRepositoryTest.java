package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach                  //각각 test 끝날 떄 마다 초기화
    public void afterEach() {
        repository.clearStore(); //객체 리스트를 비우기로 함.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");       //객체 생성 후 설정.

        repository.save(member);        //MemoryMemberRepository의 save를 사용한다.

        Member result = repository.findById(member.getId()).get();  //설정 된 객체의 id를 가져오고 그 객체를 get()
        Assertions.assertEquals(member, result); //같으면 통과 아님 오류
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("testname1");
        repository.save(member1);

        Member result = repository.findByName("testname1").get(); //위에 저장이 잘되었나 "testname1" 이름을 가진 객체를 가져와보는것.

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("testname1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("testname2");
        repository.save(member2);

        List<Member> result = repository.findAll(); //위에 테스트 값 제대로 들어갔나 리스트 가져와보기

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2); //객체 두개 있나 확인
    }

}
