package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
        System.out.println("setUrl: " + url);
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    // 인터페이스를 사용하는 초기화, 종료 방법은 스프링 초창기에 나온 방법
    // 지금은 다음의 더 나은 방법들이 있어서 거의 사용하지 않는다.
    // 빈 생성 후 의존 관계 주입 후
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 빈 closing 후
    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
