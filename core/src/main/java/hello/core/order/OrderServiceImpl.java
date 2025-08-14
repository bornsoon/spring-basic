package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
// final 이 붙은 필드를 모아서 생성자를 자동으로 만들어줌!
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // final: 생성자에서 반드시 초기화되어야 함, 초기화 이후 절대로 변경되지 않음
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /* 수정자 주입
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository (setter) = " + memberRepository);  //출력순서: 2(3)
        // this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy (setter) = " + discountPolicy);  //출력순서: 3(2)
        // this.discountPolicy = discountPolicy;
    }*/

    /* 생성자 주입
    // @Autowired  스프링빈이 생성자가 딱 한개일 때는 자등으로 @Autowired 처리
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("`memberRepository (생성자) = " + memberRepository);  // 출력순서: 1
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
