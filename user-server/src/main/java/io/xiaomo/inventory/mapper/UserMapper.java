package io.xiaomo.inventory.mapper;

import io.xiaomo.inventory.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User findById(@Param("id")Long id);

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(@Param("id")Long id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 获得用户列表
     * @param user
     * @return
     */
    List<User> getList(User user);
}
