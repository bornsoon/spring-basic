package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 애플리케이션의 구성(설정) 정보
public class AppConfig {

    // @Bean MemberService 생성 -> new MemoryMemberRepository() 호출
    // @Bean orderService 생성 -> new MemoryMemberRepository() 호출
    // 2개의 MemoryMemberRepository가 생성되면서 싱글톤 깨짐?

    // 생성자 주입
    @Bean // 스프링 컨테이너에 등록 (key: 메소드명, value: 반환값)
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());   // Ctrl + Alt + M > Extract Method
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    //`@Configuration + @Bean`을 통해 빈으로 등록할 때,
    // static 메서드로 할 경우 "싱글톤" 보장해주지 못함!!!!!
    // private static MemoryMemberRepository memberRepository() {return new MemoryMemberRepository();}

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    // call AppConfig.memberService
    // call AppConfig.memberRepository -> X
    // call AppConfig.orderService
    // call AppConfig.memberRepository-> X
    // call AppConfig.memberRepository
}
