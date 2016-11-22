package com.bangduoduo.monkey;

import com.bangduoduo.monkey.ApplicationContextProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cpeng2 on 11/22/2016.
 */
@Configuration
public class InitializeBeans {
    @Bean
    public ApplicationContextProvider getApplicationContextProvider() {
        return new ApplicationContextProvider();
    }
}
