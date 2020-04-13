package org.dhbw.service.student.controller;

import java.util.List;
import java.util.Optional;

import org.dhbw.service.student.model.Student;
import org.dhbw.service.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * StudentController
 */
@RestController
public class StudentController {

    @Autowired
    StudentRepository StudentRepo;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        List<Student> allStudents = (List) StudentRepo.findAll();
        return allStudents;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student stud = StudentRepo.findById(id).get();
        return stud;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student newStudent) {
        Student s = StudentRepo.save(newStudent);
        return s;
    }

    @DeleteMapping("/student/{id}")
    public Student deleteStudentById(@PathVariable Long id) {
        Optional<Student> StudentToDelete = StudentRepo.findById(id);

        if(StudentToDelete.isPresent()) {
            StudentRepo.delete(StudentToDelete.get());
            return StudentToDelete.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + id + " nicht gefunden.");
        }
    }
}