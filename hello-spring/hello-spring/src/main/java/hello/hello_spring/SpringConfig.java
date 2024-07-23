package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private EntityManager em;
    private DataSource dataSource;

   @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
       this.dataSource = dataSource; //데이터베이스 연결 및 관리
       this.em = em; //jpa
       this.memberRepository = memberRepository; //spring jpa 사용을위해 레포도
    }

    @Bean           //configuration인거 알고 @Bean 붙인 함수는 호출되어 컨테이너에 들어감 => 관리
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //스프링jpa 가 자동으로 레포 만들어 빈에 저장해두어 밑처럼 반환코드가 필요없음.
    //@Bean
    //public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();    //구현체 반환
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    //}

    @Bean
    public TimeTraceAop timeTraceAop() {
       return new TimeTraceAop();
    }
}
