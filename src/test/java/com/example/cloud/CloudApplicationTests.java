package com.example.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")  // "test" 프로파일을 사용
class CloudApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // ApplicationContext가 정상적으로 로드되었는지 확인
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void beanExistenceTest() {
        // 특정 빈이 ApplicationContext에 존재하는지 확인
        boolean isBeanPresent = applicationContext.containsBean("myService");
        assertThat(isBeanPresent).isTrue();
    }
}