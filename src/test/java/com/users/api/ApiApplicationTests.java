package com.users.api;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

    @InjectMocks
    private ApiApplication apiApplication;
    @InjectMocks
    private ServletInitializer servletInitializer;
    @Mock
    SpringApplicationBuilder application;

    @Test
    void contextLoads() {
    }

    @Test
    void testMain(){
        apiApplication.main(new String[]{});
    }

    @Test
    void testConfigure(){
        servletInitializer.configure(application);
    }
}
