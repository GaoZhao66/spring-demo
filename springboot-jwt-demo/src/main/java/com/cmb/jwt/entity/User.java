package com.cmb.jwt.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author gaozhao
 * @创建时间 2019/11/19
 * @描述
 **/
@Entity
@Table(name = "jd_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
