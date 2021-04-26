package io.xiaomo.common;

import lombok.Data;

/**
 * 结果对象
 * @param <T>
 */
@Data
public class Result<T>{

    private boolean success;
    private String msg;
    private T data;
}
