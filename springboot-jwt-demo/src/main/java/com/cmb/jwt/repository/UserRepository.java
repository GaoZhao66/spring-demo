package com.cmb.jwt.repository;

import com.cmb.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * @Author gaozhao
 * @创建时间 2019/11/22
 * @描述
 **/
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
