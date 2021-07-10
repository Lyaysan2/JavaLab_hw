package ru.itis;

import ru.itis.models.Course;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository {
    List<Course> findAll();
    Optional<Course> findById(Integer id);
    List<Course> findAllByName(String name);
    void update(int id, Course course);
    void save(Course course);
    void delete(Integer id);
}
