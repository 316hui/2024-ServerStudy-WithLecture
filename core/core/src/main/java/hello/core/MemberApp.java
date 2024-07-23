package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static hello.core.member.Grade.BASIC;

public class MemberApp {
    public static void main(String args[]) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService(); //memberServiceImpl 객체 반환옴

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //appconfig @configuration 구성을 사용해 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //memberservice 함수에서 MemberService.class 타입을 가져옴

        Member member1 = new Member(1L, " 예진", BASIC);
        memberService.join(member1);

        Member findMember = memberService.findById(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member1 = " + member1.getName());

        //Assertions 는 junit test 공간에서만 사용가능
    }
}
