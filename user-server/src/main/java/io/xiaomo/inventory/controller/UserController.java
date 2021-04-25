package io.xiaomo.inventory.controller;

import io.swagger.annotations.*;
import io.xiaomo.inventory.entity.User;
import io.xiaomo.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path="findById",method = RequestMethod.GET)
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="id",dataType="Long",required=true,value="user的id")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    public User findById(@RequestParam(name="id",required = true) Long id){

        User user = this.userService.findById(id);
        return user;
    }

    @RequestMapping(path="getList",method = RequestMethod.GET)
    @ApiOperation("获取用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="id",dataType="Long",required=false,value="user的id"),
            @ApiImplicitParam(paramType="query",name="username",dataType="String",required=false,value="username")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    public List<User> getList(//
            @RequestParam(name="id",required = false) Long id,//
            @RequestParam(name="username",required = false) String username//
    ){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        List<User> users = this.userService.getList(user);
        return users;
    }
}
