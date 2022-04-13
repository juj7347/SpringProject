package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() { //MemberService 역할
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() { //MemberRepository 역할
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() { //OrderService 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }
}
