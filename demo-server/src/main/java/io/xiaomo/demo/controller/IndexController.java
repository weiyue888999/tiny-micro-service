package io.xiaomo.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.xiaomo.demo.clients.UserServiceClient;
import io.xiaomo.demo.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @NacosValue(value = "${enableDisplay:true}", autoRefreshed = true)
    private boolean enableDisplay;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping("/")
    public String index(){

        Map<String,Object> vals = new HashMap<String,Object>();
        vals.put("id",Long.valueOf(1L));
        UserEntity user = this.restTemplate.getForObject("http://USER-SERVER/user/findById?id={id}",UserEntity.class,vals);

        System.out.println(user);

        UserEntity u2 = this.userServiceClient.findById(1L);
        System.out.println(u2);

        List<UserEntity> users = this.userServiceClient.getList(new UserEntity());
        System.out.println("getList");
        for(UserEntity ue : users){
            System.out.println(ue);
        }

        return "index";
    }
}
