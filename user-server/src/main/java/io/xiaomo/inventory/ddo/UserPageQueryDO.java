package io.xiaomo.inventory.ddo;

import io.xiaomo.common.PageQueryDO;
import lombok.Data;

@Data
public class UserPageQueryDO extends PageQueryDO {
    private String username;
}
