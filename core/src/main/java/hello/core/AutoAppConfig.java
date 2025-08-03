package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//`@ComponentScan->`@Component`어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
@ComponentScan( 
        //@Configuration이 붙은 설정 정보도 자동으로 등록되기 때문에 예외 설정(기존 예제 코드 남기기 위해)
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes =
        Configuration.class)
)
public class AutoAppConfig {
}
