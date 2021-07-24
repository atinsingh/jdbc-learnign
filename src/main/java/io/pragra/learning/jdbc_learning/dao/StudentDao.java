package io.pragra.learning.jdbc_learning.dao;

import io.pragra.learning.jdbc_learning.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/*
This class will provide database CRUD operation for our student table
 */
@Repository
public class StudentDao {

    JdbcTemplate template;

    public StudentDao(JdbcTemplate template) {
        this.template = template;
    }

    public Student createStudent(Student student) {
        student.setId(((int) Math.floor(Math.random() * 1000000)));

        String sql = "INSERT INTO STUDENT VALUES( ? , ?, ? ,?, ?, ? )";

        template.update(sql, student.getId(), student.getFirstName(), student.getLastName(), student.getCreateDate(), student.getUpdateDate(), student.getStatus().toString());

        return  student;
    }


    public List<Student> getAllStudent() {
        return template.query("SELECT * FROM STUDENT", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getStudentById(int id){
        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = ? ", new BeanPropertyRowMapper<>(Student.class), id);
    }

    public int updateLastName(Student student){
        String sql = "UPDATE STUDENT SET LAST_NAME = ? WHERE ID = ?";
        return template.update(sql,student.getLastName(),student.getId());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM STUDENT WHERE ID = ? ";
        template.update(sql, id);
    }
}
