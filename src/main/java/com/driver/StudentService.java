package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public void addStudent(Student student){
        repository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repository.addTeacher(teacher);
    }
    public void addTeacherStudentsPair(String student,String teacher){
        repository.addTeacherStudentsPair(student,teacher);
    }
    public Student getStudentByName(String student){
        return repository.getStudentByName(student);
    }
    public Teacher getTeacherByName(String teacher){
        return repository.getTeacherByName(teacher);
    }
    public List<String> StudentsByTeacherName(String teacher){
        return repository.StudentsByTeacherName(teacher);
    }
    public List<String> AllStudents(){
        return repository.AllStudents();
    }
    public void deleteTeacherByName(String teacher){
        repository.deleteByTeacherName(teacher);
    }
    public void deleteAllTeachers(){
        repository.deleteAllTeachers();
    }
}
