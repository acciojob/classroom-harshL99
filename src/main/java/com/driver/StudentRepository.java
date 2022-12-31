package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private Map<String,Student> StudentMap=new HashMap<>();
    private Map<String,Teacher> TeacherMap=new HashMap<>();
    private Map<String, List<Student>> TeacherStudents=new HashMap<>();

    //Add a Student
    public void addStudent(Student student){
        StudentMap.put(student.getName(),student);
    }

    //Add a Teacher
    public void addTeacher(Teacher teacher){
        TeacherMap.put(teacher.getName(),teacher);
    }
    public void addTeacherStudentsPair(String student,String teacher){
        if(StudentMap.containsKey(student) && TeacherMap.containsKey(teacher)){
            List<Student> students=new ArrayList<>();
            if(TeacherStudents.containsKey(teacher)) {
                students = TeacherStudents.get(teacher);

                for (Student st : students) {
                    if (st.getName().equals(student)) return;
                }
            }
            students.add(StudentMap.get(student));
            TeacherStudents.put(teacher,students);
        }
    }
    public Student getStudentByName(String student){
            return StudentMap.get(student);
    }
    public Teacher getTeacherByName(String teacher){
        return TeacherMap.get(teacher);
    }
    public List<String> StudentsByTeacherName(String teacher){
        List<String> students=new ArrayList<>();
        if(TeacherStudents.containsKey(teacher)){
            for(Student student : TeacherStudents.get(teacher)){
                students.add(student.getName());
            }
        }
        return students;
    }
    public List<String> AllStudents(){
        List<String> students=new ArrayList<>();

        for(String student : StudentMap.keySet())
            students.add(student);

        return students;
    }
    public void deleteByTeacherName(String teacher){
        TeacherMap.remove(teacher);
        List<String> students=new ArrayList<>();

        for(Student student : TeacherStudents.get(teacher))
            students.add(student.getName());

        for(String s : students)
            StudentMap.remove(s);

        TeacherStudents.remove(teacher);
    }
    public void deleteAllTeachers(){
        Set<String> teachers=new HashSet<>();
        teachers=TeacherStudents.keySet();

        for(String teacher : teachers)
            TeacherMap.remove(teacher);

        for(String teacher : teachers){
            for(Student student : TeacherStudents.get(teacher)){
                StudentMap.remove(student.getName());
            }
        }
    }
}
