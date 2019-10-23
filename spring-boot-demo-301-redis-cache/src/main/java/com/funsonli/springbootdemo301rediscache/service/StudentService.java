package com.funsonli.springbootdemo301rediscache.service;

import com.funsonli.springbootdemo301rediscache.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * Class for
 *
 * @author Funson
 * @date 2019/10/14
 */
public interface StudentService {
    List<Student> index();
    Student save(Student student);
    Optional<Student> findById(String id);
    void deleteById(String id);
}
