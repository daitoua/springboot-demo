package com.daitou.springbootdemo.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.daitou.springbootdemo.api.model.User;
import com.daitou.springbootdemo.api.service.impl.QueryUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class HelloWorldController {

    @Autowired
    private QueryUserServiceImpl queryUserServiceImpl;
    @Resource
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/hi")
    public ModelAndView index(){
        log.info("????????");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("key","呆头来啦");
        return modelAndView;
    }


    /*redis 存入json整合成功*/
    @RequestMapping(value = "/query")
    public ModelAndView queryUser(Model model){
        List<User> users = queryUserServiceImpl.queryUser();
        for (User user : users) {
            log.info(user.getId() + user.getUserName() + user.getPassWord());
            System.out.println(user);

            redisTemplate.opsForValue().set("user",JSONObject.toJSON(user));

            User user1 = JSONObject.parseObject(redisTemplate.opsForValue().get("user").toString(), User.class);

            System.out.println("user1" + "============>" + user1);


        }







        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("key","呆头来啦");
        return modelAndView;
    }


}
