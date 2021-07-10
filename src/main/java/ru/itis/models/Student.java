package ru.itis.models;

public class Student {
    private Integer id_student;
    private String s_first_name;
    private String s_last_name;
    private String group_number;

    public Student(Integer id_student, String s_first_name, String s_last_name, String group_number) {
        this.id_student = id_student;
        this.s_first_name = s_first_name;
        this.s_last_name = s_last_name;
        this.group_number = group_number;
    }

    public Student(String s_first_name, String s_last_name, String group_number) {
        this.s_first_name = s_first_name;
        this.s_last_name = s_last_name;
        this.group_number = group_number;
    }

    public Integer getId_student() {
        return id_student;
    }

    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }

    public String getS_first_name() {
        return s_first_name;
    }

    public void setS_first_name(String s_first_name) {
        this.s_first_name = s_first_name;
    }

    public String getS_last_name() {
        return s_last_name;
    }

    public void setS_last_name(String s_last_name) {
        this.s_last_name = s_last_name;
    }

    public String getGroup_number() {
        return group_number;
    }

    public void setGroup_number(String group_number) {
        this.group_number = group_number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", s_first_name='" + s_first_name + '\'' +
                ", s_last_name='" + s_last_name + '\'' +
                ", group_number='" + group_number + '\'' +
                '}';
    }
}
