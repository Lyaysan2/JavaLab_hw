package ru.itis;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.Course;
import ru.itis.models.Lesson;
import ru.itis.models.Teacher;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.*;

public class LessonsRepositoryJdbcTemplateImpl implements LessonsRepository {

    private static final String SQL_SELECT_BY_ID = "select * from lesson left join course on id_course = lesson.l_id_course left outer join teacher on id_teacher = c_id_teacher where id_lesson = ?";
    private static final String SQL_SELECT_ALL = "select * from lesson left join course on l_id_course = id_course left join teacher on c_id_teacher = id_teacher";
    private static final String SQL_SELECT_ALL_BY_NAME = "select * from lesson left join course on l_id_course = id_course left join teacher on c_id_teacher = id_teacher where l_name = ?";
    private static final String SQL_INSERT = "insert into lesson (l_name, day_of_week_time, l_id_course)  values(?, ?, ?)";
    private static final String SQL_UPDATE_BY_ID = "update lesson set l_name = ?, day_of_week_time = ?, l_id_course = ? where id_lesson = ?";
    private static final String SQL_DELETE_BY_ID = "delete from lesson where id_lesson = ?";

    private JdbcTemplate jdbcTemplate;

    public LessonsRepositoryJdbcTemplateImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Lesson> lessonRowMapper = (row, rowNumber) -> {
        int id_lesson = row.getInt("id_lesson");
        String l_name = row.getString("l_name");
        String day_of_week_time = row.getString("day_of_week_time");

        int id_course = row.getInt("id_course");
        String c_name = row.getString("c_name");
        String data_begin_end = row.getString("data_begin_end");

        Teacher teacher = new Teacher(row.getInt("id_teacher"), row.getString("t_first_name"),
                row.getString("t_last_name"), row.getInt("experience"));

        Course course = new Course(id_course, c_name, data_begin_end, teacher);
        Lesson lesson = new Lesson(id_lesson, l_name, day_of_week_time, course);

        return lesson;
    };


    @Override
    public List<Lesson> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, lessonRowMapper);
    }

    @Override
    public Optional<Lesson> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, lessonRowMapper, id));
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Lesson> findAllByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_NAME, lessonRowMapper, name);
    }

    @Override
    public void update(int id_lesson, Lesson lesson) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, lesson.getL_name(), lesson.getDay_of_week_time(), lesson.getL_id_course(), id_lesson);
    }

    @Override
    public void save(Lesson course) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[] {"id_lesson"});

            statement.setString(1, course.getL_name());
            statement.setString(2, course.getDay_of_week_time());
            statement.setInt(3, course.getL_id_course());

            return statement;
        }, keyHolder);
        course.setId_lesson(keyHolder.getKey().intValue());
    }

    @Override
    public void delete(Integer id_lesson) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id_lesson);
    }
}
