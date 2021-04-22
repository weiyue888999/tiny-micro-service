package io.xiaomo.user.service;

import io.xiaomo.user.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> getList(User user);
}
