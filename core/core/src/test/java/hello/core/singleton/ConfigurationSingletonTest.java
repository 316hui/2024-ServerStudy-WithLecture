package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memRepo1 = memberService.getMemberRepository();
        MemberRepository memRepo2 = orderService.getMemberRepository();

        Assertions.assertThat(memRepo1).isSameAs(memRepo2);
        //appConfig에 memberRepository()는 new 함에도 불구하고 빈으로 관리되기 떄문에
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        //부모를 get하니 자식까지 나옴. -> appConfig cglib
        //appConfig cglib 이 등록되어있다. 최초가 아니면 스프링컨테이너에 저장하고, 재활용하도록 함.

        //appconfig를 @configuration 이 아닌 @bean 으로 등록해도 관리는 해주지만, cglib 생성이 안되면서 싱글톤은 보장안함
        System.out.println("bean = " + bean.getClass());
    }
}
