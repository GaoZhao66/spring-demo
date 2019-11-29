package com.cmb.jwt.model;

import lombok.Data;

/**
 * @Author gaozhao
 * @创建时间 2019/11/28
 * @描述
 **/
@Data
public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;
}
