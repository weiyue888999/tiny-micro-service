package io.xiaomo.inventory.controller;

import io.swagger.annotations.*;
import io.xiaomo.common.PageResult;
import io.xiaomo.common.Result;
import io.xiaomo.inventory.ddo.UserPageQueryDO;
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
    public Result<User> findById(@RequestParam(name="id",required = true) Long id){

        User user = this.userService.findById(id);
        if(user != null){
            Result<User> result  = new Result<>();
            result.setData(user);
            result.setSuccess(true);
            return result;
        }else{
            Result<User> result  = new Result<>();
            result.setSuccess(false);
            return result;
        }
    }

    @RequestMapping(path="getPageList",method = RequestMethod.GET)
    @ApiOperation("获取用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="username",dataType="String",required=false,value="username"),
            @ApiImplicitParam(paramType="query",name="pageIndex",dataType="Integer",required=true,defaultValue = "1",value="pageIndex"),
            @ApiImplicitParam(paramType="query",name="pageSize",dataType="Integer",required=true,defaultValue = "10",value="pageSize"),
    })
    public PageResult<List<User>> getList(//
                                          @RequestParam(name="username",required = false) String username,
                                          @RequestParam(name="pageIndex",required = true,defaultValue = "1") Integer pageIndex,
                                          @RequestParam(name="pageSize",required = true,defaultValue = "10") Integer pageSize
    ){

        UserPageQueryDO userPageQueryDO = new UserPageQueryDO();
        userPageQueryDO.setUsername(username);
        userPageQueryDO.setPageIndex(pageIndex);
        userPageQueryDO.setPageSize(pageSize);

        int cnt = this.userService.getListCount(userPageQueryDO);
        List<User> users = this.userService.getPageList(userPageQueryDO);
        PageResult<List<User>> result = new PageResult<>();
        result.setData(users);
        result.setSuccess(true);
        result.setCurPage(pageIndex);
        result.setTotalNum(cnt);
        result.setPageSize(pageSize);
        return result;
    }
}
