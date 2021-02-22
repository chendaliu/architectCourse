package com.czl.es.repository;

import com.czl.es.domain.Student;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-21 16:46
 * @Version:1.0
 **/
public interface StudentRepository extends ElasticsearchRepository<Student, String> {

    /**
     * 通过姓名模拟查询学生信息
     * @param keyword
     * @return
     */
    List<Student> findByNameLike(String keyword);

    /**
     * 自定义查询，固定匹配查询学生信息
     * @param keyword
     * @return
     */
    @Query("{\"match_phrase\":{\"name\":\"?0\"}}")
    List<Student> findByNameCustom(String keyword);
}