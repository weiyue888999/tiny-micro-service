package io.xiaomo.common;

import lombok.Data;

/**
 * 分页查询继承这个类进行扩展
 */
@Data
public class PageQueryDO {

    private Integer pageIndex = 1;

    private Integer pageSize = 10;

    public Integer getOffset(){
        if(pageIndex == null){
            pageIndex = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return (pageIndex - 1) * pageSize;
    }

}
