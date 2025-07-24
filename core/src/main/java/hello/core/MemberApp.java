package hello.core;

import ch.qos.logback.core.net.SyslogOutputStream;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        // 구현 객체의 선택은 appConfig가 담당
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // Bean 객체 관리하는 개체
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// (bean 이름, 반환타입)

        // Command + Option + v / Ctrl + Alt + v
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        // soutv
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
