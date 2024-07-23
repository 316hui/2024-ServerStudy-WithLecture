package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //private, static, 해당 클래스 객체 생성 전에 미리 존재(static에 위치)

    public static SingletonService getInstance() { //위 객체는 private로 여기서만 조회가능
        return instance;
    }

    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 출력");
    }
    //스프링컨테이너는 등록된거 알아서 싱글톤으로 만들어줌..
    //테스트 어렵고, 싱글톤을 사용하려면 getInstance() 라는 구현체에 접근해야 함으로 문제.
}
