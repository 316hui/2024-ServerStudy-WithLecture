package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackageClasses = AutoAppConfig.class, //component 찾는 시작 위치(머리)
        //basePackages = "hello.core.member", //component 찾는 특정 범위
        //위가 없으면 @ComponentScan 붙은게 시작위치가 되니, 설정정보클래스를 프로젝트 최상단에 올리는것을 추천
        //springBootApplication -> @ComponentScan/ @Component -> @Controller, @Service @Repository @Configuration
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)

public class AutoAppConfig {
}
