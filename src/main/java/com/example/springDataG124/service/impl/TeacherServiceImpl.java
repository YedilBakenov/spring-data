package com.example.springDataG124.service.impl;

import com.example.springDataG124.model2.Car;
import com.example.springDataG124.model2.Teacher;
import com.example.springDataG124.repository2.TeacherRepository2;
import com.example.springDataG124.service.CarService;
import com.example.springDataG124.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository2 teacherRepository2;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository2.findAll();
    }
}
