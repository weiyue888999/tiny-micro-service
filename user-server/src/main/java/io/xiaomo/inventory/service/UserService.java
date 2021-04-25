package io.xiaomo.inventory.service;

import io.xiaomo.inventory.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> getList(User user);
}
