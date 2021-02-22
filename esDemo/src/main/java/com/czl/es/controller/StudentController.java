package com.czl.es.controller;

import com.czl.es.domain.Student;
import com.czl.es.repository.StudentRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-21 16:47
 * @Version:1.0
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 批量添加
     * @param students
     * @return
     */
    @PostMapping("/batchAdd")
    public void add(@RequestBody List<Student> students){
        studentRepository.saveAll(students);
    }

    /**
     * 添加
     * @param student
     * @return
     */
    @PostMapping("/add")
    public void add(@RequestBody Student student){
        studentRepository.save(student);
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @PostMapping("/update")
    public void updateById(@RequestBody Student student){
        studentRepository.save(student);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        studentRepository.deleteById(id);
    }

    /**
     * 获取所有信息
     * @return
     */
    @GetMapping("/get")
    public Object getAll(){
        Iterable<Student> iterable = studentRepository.findAll();
        List<Student> list = new ArrayList<>();
        iterable.forEach(list :: add);
        return list;
    }

    /**
     * 查询指定ID
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Object getById(@PathVariable String id){
        if(StringUtils.isEmpty(id)){
            return "error";
        }
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }


    /**
     * 普通搜索
     * @param keyword
     * @return
     */
    @GetMapping("/search/name")
    public Object searchName(String keyword){
        List<Student> students = studentRepository.findByNameLike(keyword);
        return students;
    }

    /**
     * 自定义匹配
     * 普通搜索
     * @param keyword
     * @return
     */
    @GetMapping("/search/name/custom")
    public Object searchTitleCustom(String keyword){
        List<Student> students = studentRepository.findByNameCustom(keyword);
        return students;
    }

    /**
     * 高级搜索，可以自定义添加搜索字段
     * @param keyword
     * @return
     */
    @GetMapping("/top/search/name")
    public Object topSearchTitle(String keyword){
        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryStringQuery(keyword))
                .build();
        //使用searchQuery进行搜索
        List<Student> students = elasticsearchTemplate.queryForList(searchQuery, Student.class);
        return students;
    }
}