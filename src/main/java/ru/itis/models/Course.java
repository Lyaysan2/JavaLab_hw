package ru.itis.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private Integer id_course;
    private String c_name;
    private String data_begin_end;
    private Integer c_id_teacher;

    private Teacher teacher;
    private List<Student> students;

    public Course(Integer id_course, String c_name, String data_begin_end, Teacher teacher) {
        this.id_course = id_course;
        this.c_name = c_name;
        this.data_begin_end = data_begin_end;
        this.teacher = teacher;
    }

    public Course(String c_name, String data_begin_end, Integer c_id_teacher, Teacher teacher) {
        this.c_name = c_name;
        this.data_begin_end = data_begin_end;
        this.c_id_teacher = c_id_teacher;
        this.teacher = teacher;
    }

    public Course(Integer id_course, String c_name, String data_begin_end) {
        this.id_course = id_course;
        this.c_name = c_name;
        this.data_begin_end = data_begin_end;
    }

    public Course(String c_name, String data_begin_end, Integer c_id_teacher) {
        this.c_name = c_name;
        this.data_begin_end = data_begin_end;
        this.c_id_teacher = c_id_teacher;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getData_begin_end() {
        return data_begin_end;
    }

    public void setData_begin_end(String data_begin_end) {
        this.data_begin_end = data_begin_end;
    }

    public Integer getC_id_teacher() {
        return c_id_teacher;
    }

    public void setC_id_teacher(Integer c_id_teacher) {
        this.c_id_teacher = c_id_teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id_course=" + id_course +
                ", c_name='" + c_name + '\'' +
                ", data_begin_end='" + data_begin_end + '\'' +
                ", " + teacher +
                ", students=" + students +
                '}';
    }
}
