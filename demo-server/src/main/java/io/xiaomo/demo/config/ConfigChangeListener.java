package io.xiaomo.demo.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.event.config.NacosConfigReceivedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigChangeListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof NacosConfigReceivedEvent){
            NacosConfigReceivedEvent nacosConfigReceivedEvent = (NacosConfigReceivedEvent)event;
            String content = nacosConfigReceivedEvent.getContent();
            System.out.println(content);
        }
        System.out.println(event);
    }
}
