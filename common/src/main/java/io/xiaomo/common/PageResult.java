package io.xiaomo.common;

import lombok.Data;

/**
 * 分页结果对象
 */
@Data
public class PageResult<T> extends Result<T>{

    private Integer totalNum;

    private Integer curPage;

    private Integer pageSize;
}
