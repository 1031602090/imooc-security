package com.imooc.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotExistException extends RuntimeException {
    private String id;
    public UserNotExistException(String id) {
        super("用户不存在！");
        this.id = id;
    }
}
