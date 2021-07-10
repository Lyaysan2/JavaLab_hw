package ru.itis;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.Course;
import ru.itis.models.Student;
import ru.itis.models.Teacher;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class CoursesRepositoryJdbcTemplateImpl implements CoursesRepository {

    private static final String SQL_SELECT_ALL = "select * from course left join course_student on id_course = course_id left join student on student_id = id_student left join teacher on c_id_teacher = id_teacher order by id_course";
    private static final String SQL_SELECT_BY_ID = "select * from course left join teacher on c_id_teacher = id_teacher where id_course = ? order by id_course";
    private static final String SQL_SELECT_ALL_BY_NAME = "select * from course left join course_student on id_course = course_id left join student on student_id = id_student left join teacher on c_id_teacher = id_teacher where c_name = ?";
    private static final String SQL_UPDATE_BY_ID = "update course set c_name = ?, data_begin_end = ?, c_id_teacher = ? where id_course = ?";
    private static final String SQL_INSERT = "insert into course (c_name, data_begin_end, c_id_teacher)  values(?, ?, ?)";
    private static final String SQL_DELETE_BY_ID = "delete from course where id_course = ?";

    private JdbcTemplate jdbcTemplate;

    public CoursesRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id_course");
        String name = row.getString("c_name");
        String data_begin_end = row.getString("data_begin_end");

        int id_teacher = row.getInt("id_teacher");
        String first_name = row.getString("t_first_name");
        String last_name = row.getString("t_last_name");
        int experience = row.getInt("experience");

        Teacher teacher = new Teacher(id_teacher, first_name, last_name, experience);

        Course course = new Course(id, name, data_begin_end, teacher);

        return course;
    };


    private final ResultSetExtractor<List<Course>> courseResultSetExtractor = rs -> {
        List<Course> courses = new ArrayList<>();
        Set<Integer> processedCourses = new HashSet<>();
        Course currentCourse = null;
        while(rs.next()){

            Teacher teacher = new Teacher(rs.getInt("id_teacher"), rs.getString("t_first_name"), rs.getString("t_last_name"), rs.getInt("experience"));

            if (!processedCourses.contains(rs.getInt("id_course"))) {
                currentCourse = new Course(rs.getInt("id_course"), rs.getString("c_name"), rs.getString("data_begin_end"), teacher);
                currentCourse.setStudents(new ArrayList<>());
                courses.add(currentCourse);
                processedCourses.add(currentCourse.getId_course());
            }

            Integer stud_id = rs.getObject("student_id", Integer.class);

            if (stud_id != null) {
                Student student = new Student(stud_id, rs.getString("s_first_name"), rs.getString("s_last_name"), rs.getString("group_number"));
                currentCourse.getStudents().add(student);

            }
        }
        return courses;
    };


    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, courseResultSetExtractor);
    }

    @Override
    public Optional<Course> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, courseRowMapper, id));
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Course> findAllByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_NAME, courseResultSetExtractor, name);
    }

    @Override
    public void update(int id_course, Course course) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, course.getC_name(), course.getData_begin_end(), course.getC_id_teacher(), id_course);
    }

    @Override
    public void save(Course course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[] {"id_course"});

            statement.setString(1, course.getC_name());
            statement.setString(2, course.getData_begin_end());
            statement.setInt(3, course.getC_id_teacher());

            return statement;
        }, keyHolder);
        course.setId_course(keyHolder.getKey().intValue());
    }

    @Override
    public void delete(Integer id_course) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id_course);
    }
}
