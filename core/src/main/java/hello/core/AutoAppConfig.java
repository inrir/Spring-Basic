package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core" , //어디서 부터 검색할 지 정할 수 있음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // AppConfig의 충돌을 피하기 위해서
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository") // 수동 빈 등록으로 충돌성 확인
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
