package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //id count

    @Override
    public Member save(Member member) {
        member.setId(++sequence);               //값세팅 따로
        store.put(member.getId(), member);      //가져오는거 따로
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //넣은 key -> id랑 같은것만 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //value -> member객체 접근해 넣은 name과 같은것만 반환
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member 객체들 반환
    }

    public void clearStore() {
        store.clear();
    }
}
