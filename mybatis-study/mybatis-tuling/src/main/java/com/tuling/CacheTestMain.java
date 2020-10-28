package com.tuling;

import com.tuling.entity.User;
import com.tuling.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-10-26 19:33
 * @Version:1.0
 **/
public class CacheTestMain {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader;

        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            //将XML配置文件构建为Configuration配置类
            // 通过加载配置文件流构建一个SqlSessionFactory  DefaultSqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.selectById(1);
        }

        try(SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.insert(new User("中国"));
            session.commit();
        } finally {
        }

        try(SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.selectById(1);
        }
    }

}