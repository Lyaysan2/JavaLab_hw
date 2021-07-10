package ru.itis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;

public class MainFile {

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("/Users/lyaysanz/Desktop/Spring JDBC/src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));
        config.setDriverClassName(properties.getProperty("db.driver"));
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikary.pool-size")));

        DataSource dataSource = new HikariDataSource(config);

        CoursesRepository coursesRepository = new CoursesRepositoryJdbcTemplateImpl(dataSource);
        LessonsRepository lessonsRepository = new LessonsRepositoryJdbcTemplateImpl(dataSource);

    }
}
