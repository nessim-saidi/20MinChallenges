package org.dhbw.service.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    Long id;
    String firstName;
    String lastName;
    String studentNumber;
}