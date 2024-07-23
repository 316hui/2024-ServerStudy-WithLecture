package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class); //여기에 들어간 클래스는 componentScan 됌. 설정 안해도.

        SingletonBean singletonBeanA = ac.getBean(SingletonBean.class);
        SingletonBean singletonBeanB = ac.getBean(SingletonBean.class);
        System.out.println(singletonBeanA);
        System.out.println(singletonBeanB);
        assertThat(singletonBeanA).isSameAs(singletonBeanB);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }

}
