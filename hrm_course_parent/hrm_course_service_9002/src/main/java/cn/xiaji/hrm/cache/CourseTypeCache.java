package cn.xiaji.hrm.cache;
//encoding: utf-8

import cn.xiaji.hrm.client.RedisClient;
import cn.xiaji.hrm.domain.CourseType;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: CourseTypeCache.java
 */
/*

 */
@Component
public class CourseTypeCache {

    @Autowired
    private RedisClient redisClient;

    private static final String TYPETREEDATA_IN_REDIS = "typetreedata_in_redis";

    //从redis获取数据
    public List<CourseType> getCourseTypes() {
        String redisData = redisClient.get(TYPETREEDATA_IN_REDIS);
        return JSONArray.parseArray(redisData, CourseType.class);
    }

    //设置数据到redis
    public void setCourseTypes(List<CourseType> courseTypes) {
        String toJSONStr = JSONArray.toJSONString(courseTypes);
        redisClient.set(TYPETREEDATA_IN_REDIS, toJSONStr);
    }


}