package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach           //테스트 생성마다 새로운 레포 생성해서 넣어주기 = 같은 레포를 공유 = 같은 store를 공유
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("testname1");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();    //반환된 id로 객체를 찾음
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
    }
    @Test
    void checkDuplicateMember() {
        //given
        Member member1 = new Member();
        member1.setName("testname111");

        Member member2 = new Member();
        member2.setName("testname111");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //오른쪽 코드를 실행하면 왼쪽오류가 터져야 통과.

        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");

//        try {
//            memberService.join(member2); //같은 이름의 객체를 넣으니 오류가 터질 수 밖에
//            fail();
//        } catch (IllegalStateException e) {
//            org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
//        }

        //then
        //여기서부터 마저작성

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}