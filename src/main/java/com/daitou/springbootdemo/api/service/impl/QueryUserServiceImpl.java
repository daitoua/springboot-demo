package com.daitou.springbootdemo.api.service.impl;


import com.daitou.springbootdemo.api.dao.QueryUserMapper;
import com.daitou.springbootdemo.api.model.User;
import com.daitou.springbootdemo.api.service.QueryUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class QueryUserServiceImpl implements QueryUserService {

    @Resource
    private QueryUserMapper queryUserMapper;

    public List<User> queryUser(){
        List<User> users = queryUserMapper.queryUser();
        return users;
    }

}
