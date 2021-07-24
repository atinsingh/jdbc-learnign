package io.pragra.learning.jdbc_learning.controller;

import io.pragra.learning.jdbc_learning.dao.StudentDao;
import io.pragra.learning.jdbc_learning.domain.Student;
import io.pragra.learning.jdbc_learning.domain.StudentStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {

    private StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
       this.studentDao = studentDao;
    }

    @GetMapping("/student")
    public Student createStudent(){
        Student student = Student.builder().firstName("Akash")
                    .lastName("Kasyap")
                .createDate(new Date())
                .status(StudentStatus.ACTIVE)
                .build();
        return studentDao.createStudent(student);

    }

    @GetMapping("/student/all")
    public List<Student> getAll(){
        return studentDao.getAllStudent();
    }


    @GetMapping("/student/all/{id}")
    public Student getAll(@PathVariable int id){
        return studentDao.getStudentById(id);
    }

    @DeleteMapping("/student/all/{id}")
    public void Delete(@PathVariable int id){
         studentDao.deleteById(id);
    }

    @PutMapping("/student")
    public int update(@RequestBody Student student){
        return studentDao.updateLastName(student);
    }

}
