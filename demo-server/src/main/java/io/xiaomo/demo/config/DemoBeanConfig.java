package io.xiaomo.demo.config;

import io.xiaomo.demo.beans.DemoBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig {

    @Bean
    public DemoBean demoBean(){
        return new DemoBean();
    }
}
