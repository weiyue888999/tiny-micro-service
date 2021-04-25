package io.xiaomo.inventory.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inventory {

    private Long id;
    private Long itemId;
    private Date crerateTime;
    private Date modifiedTime;
    private Long cnt;
    private Long version;

}
