package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean proto1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean proto2 = ac.getBean(PrototypeBean.class);
        System.out.println(proto1);
        System.out.println(proto2);

        assertThat(proto1).isNotSameAs(proto2);
        ac.close();
        //특. 빈 생성 마다 프로토스코프 다르고, destory 호출 안 함. => 컨테이너에서 프로토 빈 조회할 때, 빈 생성
        //생성, 의존주입, 초기화만 하고 컨테이너에서 나오기 때문에 detroy도 못하는것.
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
