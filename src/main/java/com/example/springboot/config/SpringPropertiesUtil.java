package com.example.springboot.config;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/6.
 * 自定义spring读取配置文件
 */
@Component
public class SpringPropertiesUtil{

    private static Environment env;

    @Resource
    public void setEnv(Environment env) {
        SpringPropertiesUtil.env = env;
    }

    public static String getProperty(String name) {
        return env.getProperty(name);
    }

}
