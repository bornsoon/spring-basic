package hello.core.singleton;

public class SingletonService {

    // static이어서 클래스당 하나만 생김
    private static final SingletonService instance = new SingletonService();

    // 자바가 뜰 때 자기자신의 객체를 생성하고 instance로 참조
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 객체 생성 금지 (private으로 외부에서 접근 불가)
    private SingletonService() {}

    /* 실수로 두 번 호출되면 객체가 중복 생성됨 -> private으로 막아버림
    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }*/
}
