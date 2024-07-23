package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    //domain 과 repository 를 사용한 비지니스 로직 작성공간

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        validateDuplicateMember(member); //중복회원 검증 (코드가 긴 경우 따로 뺀다)
        memberRepository.save(member);
        return member.getId();              //가입하면 id 반환
    }

    private void validateDuplicateMember(Member member) {
        //근데 이미 존재하는 회원은 안됌
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
            });
        //ifPresent는 Optional 메서드~
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
