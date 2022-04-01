package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions; // Assertions를 이거를 사용한다.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        // given -> 이런이런 환경이 주어졌을떄
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when -> 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

       // then -> 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
