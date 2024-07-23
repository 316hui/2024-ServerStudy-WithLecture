package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented //여기까지 어노테이션 @Qualifier 의 것을 가져온것. = 같은 기능작동
@Qualifier("mainDiscountPolicy") //이 어노테이션 이름이 틀리는 경우엔 오류가 뜨니 잡기쉽다.
public @interface MainDiscountPolicy {
}
//같은 타입의 빈이더라도 
//즉 @MainDiscountPolicy 클래스를 달고 있는 클래스가 @Qulifier("mainDiscountPolicy") 이니 우선순위를 가지는것.