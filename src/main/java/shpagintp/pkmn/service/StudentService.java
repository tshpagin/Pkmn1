package shpagintp.pkmn.service;

import shpagintp.pkmn.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentByFullName(String firstName, String surName, String familyName);

    List<Student> getStudentsByGroup(String group);

    Student saveStudent(Student student);
}
