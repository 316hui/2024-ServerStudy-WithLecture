package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //덕분에 getter setter 생성필요 없음.
public class HelloData {

    private String username;
    private int age;

}
