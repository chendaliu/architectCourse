package pers.czl.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pers.czl.entity.User;

import java.io.IOException;
import java.io.Reader;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-10-22 16:37
 * @Version:1.0
 **/
public class MybatisMain {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("pers.czl.mapper.UserMapper.selectById", 1);
            //sqlSession.commit();
            System.out.println(user);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}