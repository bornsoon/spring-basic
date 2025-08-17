package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();  // application context 닫기 (ConfigurableApplicationContext 클래스에서 제공)
    }

    @Configuration
    static class LifeCycleConfig {

        //@Bean(initMethod = "init", destroyMethod= "close")
        // 종료 메서드 자동 추론: String destroyMethod() default "(inferred)";
        // -> 대부분의 라이브러리가 사용하는 종료 메서드인 "close" 또는 "shutdown" 메서드를 자동으로 호출
        @Bean // +@PostConstruct, @PreDestroy: 권장 방법 (스프링이 아닌 다른 컨테이너에서도 동작, 외부 라이브러리는 X)
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
