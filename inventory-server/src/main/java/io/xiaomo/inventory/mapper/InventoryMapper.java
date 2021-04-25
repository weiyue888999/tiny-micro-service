package io.xiaomo.inventory.mapper;

import io.xiaomo.inventory.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryMapper {
    /**
     * 通过id查询库存
     * @return
     */
    Inventory findByItemId(@Param("itemId")Long itemId);

    /**
     * 插入库存
     * @param inventory
     * @return
     */
    int insert(Inventory inventory);

    /**
     * 更新库存
     * @param user
     * @return
     */
    int update(Inventory inventory);

    int incressCnt(Inventory inventory);

    int descresCnt(Inventory inventory);
}
