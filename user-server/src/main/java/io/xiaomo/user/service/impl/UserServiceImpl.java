package io.xiaomo.user.service.impl;

import io.xiaomo.user.entity.User;
import io.xiaomo.user.mapper.UserMapper;
import io.xiaomo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    @Cacheable(cacheNames = "user")
    public User findById(Long id){
        return this.userMapper.findById(id);
    }

    @Override
    public List<User> getList(User user) {
        return this.userMapper.getList(user);
    }
}
