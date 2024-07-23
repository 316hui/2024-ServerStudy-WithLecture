package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("aaaaa");

        String name = helloLombok.getName(); //롬복, @Getter @Setter로 자바코드 짜지 않아도 사용가능.
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
