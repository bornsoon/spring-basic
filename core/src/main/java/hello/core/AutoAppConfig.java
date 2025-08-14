package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//`@ComponentScan->`@Component`어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
@ComponentScan( // 기본 조회 - @ComponentScan이 붙은 클래스의 패키지의 하위 패키지만 조회
        basePackages = "hello.core", // 이 패키지의 하위 패키지에서만 스캔
        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 기준으로 탐색
        //@Configuration이 붙은 설정 정보도 자동으로 등록되기 때문에 예외 설정(기존 예제 코드 남기기 위해)
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes =
        Configuration.class)
)
public class AutoAppConfig {

    // 수동 빈 등록이 우선권을 가짐 -> 오버라이딩 되버림 -> 디폴드 설정은 오버라이딩 X
    // test는 성공해도 실제로 프로젝트 실행하면 오류 뜸
    /*
    @Bean(name="memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
