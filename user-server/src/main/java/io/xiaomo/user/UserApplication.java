package io.xiaomo.user;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "io.xiaomo.user")
@ServletComponentScan(basePackages = "spring.cloud.demo.servlet")
@EnableCaching
@EnableSwagger2
@NacosPropertySource(dataId = "user-server", autoRefreshed = true)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
