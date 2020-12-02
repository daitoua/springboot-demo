package com.daitou.springbootdemo.api.dao;

import com.daitou.springbootdemo.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QueryUserMapper {

    List<User> queryUser();

}
