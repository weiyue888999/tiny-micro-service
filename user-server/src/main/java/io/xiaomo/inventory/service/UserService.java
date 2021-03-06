package io.xiaomo.inventory.service;

import io.xiaomo.inventory.ddo.UserPageQueryDO;
import io.xiaomo.inventory.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> getPageList(UserPageQueryDO userPageQueryDO);

    int getListCount(UserPageQueryDO userPageQueryDO);
}
