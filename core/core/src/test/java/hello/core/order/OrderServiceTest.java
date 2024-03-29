package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
//    MemberService memberService = new MemberServiceImple();
//    OrderService orderService = new OrderServiceImpl(memberRepository, discountPollicy);
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void orderTest() {
        Long memberId = 9L;
        Member testMember = new Member(memberId, "Hoiya~", Grade.VIP);
        memberService.join(testMember);

        Order testOrder = orderService.createOrder(memberId, "Jibegagoshipdda", 9999);

        Assertions.assertThat(testOrder.getDiscoutPrice()).isEqualTo(999);
    }
}
