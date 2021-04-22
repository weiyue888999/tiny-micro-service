package io.xiaomo.demo.clients;

import io.xiaomo.demo.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("USER-SERVER")
@RequestMapping("/user")
public interface UserServiceClient {

    @RequestMapping(path="findById",method= RequestMethod.GET)
    UserEntity findById(@RequestParam("id") Long id);

    @RequestMapping(path="getList",method= RequestMethod.GET)
    List<UserEntity> getList(@SpringQueryMap UserEntity userEntity);

}
