package com.example.springDataG124.service;

import com.example.springDataG124.model2.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> getAllTeachers();

}
