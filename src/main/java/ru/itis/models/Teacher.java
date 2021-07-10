package ru.itis.models;

public class Teacher {
    private Integer id_teacher;
    private String t_first_name;
    private String t_last_name;
    private Integer experience;

    public Teacher(Integer id_teacher, String t_first_name, String t_last_name, Integer experience) {
        this.id_teacher = id_teacher;
        this.t_first_name = t_first_name;
        this.t_last_name = t_last_name;
        this.experience = experience;
    }

    public Teacher(String t_first_name, String t_last_name, Integer experience) {
        this.t_first_name = t_first_name;
        this.t_last_name = t_last_name;
        this.experience = experience;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getT_first_name() {
        return t_first_name;
    }

    public void setT_first_name(String t_first_name) {
        this.t_first_name = t_first_name;
    }

    public String getT_last_name() {
        return t_last_name;
    }

    public void setT_last_name(String t_last_name) {
        this.t_last_name = t_last_name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id_teacher=" + id_teacher +
                ", t_first_name='" + t_first_name + '\'' +
                ", t_last_name='" + t_last_name + '\'' +
                ", experience=" + experience +
                '}';
    }
}


