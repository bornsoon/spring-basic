package hello.core.score;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        // 파라미터 안의 클래스가 자동으로 컴포넌트 스캔되서 등록됨
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close(); // 테스트에서는 명시적으로 close 해줘야지 @PreDestroy 호출됨
        /*
        싱글톤 스코프 bean은 컨텍스트가 종료될 때(context.close() 또는 SpringApplication 종료) @PreDestroy 메소드가 자동 호출.
        하지만 테스트 환경에서는 @SpringBootTest 같은 걸 쓰더라도, ApplicationContext 자체가 강제로 닫히지 않으면 @PreDestroy는 호출되지 않음.
         */
    }

    @Scope("singleton") // singleton은 원래 디폴트값 안적어줘도 ok
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
