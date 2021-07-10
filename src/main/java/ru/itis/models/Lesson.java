package ru.itis.models;

public class Lesson {
    private Integer id_lesson;
    private String l_name;
    private String day_of_week_time;
    private Integer l_id_course;

    private Course course;

    public Lesson(Integer id_lesson, String l_name, String day_of_week_time, Course course) {
        this.id_lesson = id_lesson;
        this.l_name = l_name;
        this.day_of_week_time = day_of_week_time;
        this.course = course;
    }

    public Lesson(String l_name, String day_of_week_time, Course course) {
        this.l_name = l_name;
        this.day_of_week_time = day_of_week_time;
        this.course = course;
    }

    public Lesson(String l_name, String day_of_week_time, Integer l_id_course) {
        this.l_name = l_name;
        this.day_of_week_time = day_of_week_time;
        this.l_id_course = l_id_course;
    }

    public Integer getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(Integer id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getDay_of_week_time() {
        return day_of_week_time;
    }

    public void setDay_of_week_time(String day_of_week_time) {
        this.day_of_week_time = day_of_week_time;
    }

    public Integer getL_id_course() {
        return l_id_course;
    }

    public void setL_id_course(Integer l_id_course) {
        this.l_id_course = l_id_course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id_lesson=" + id_lesson +
                ", l_name='" + l_name + '\'' +
                ", day_of_week_time='" + day_of_week_time + '\'' +
                ", course=" + course +
                '}';
    }
}
