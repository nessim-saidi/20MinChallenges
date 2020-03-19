package org.dhbw.service.student.controller;

import org.dhbw.service.student.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 */
@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student newStudent = new  Student(new Long(1), "Thomas", "Tester", "4711");
        return newStudent;
    }
}