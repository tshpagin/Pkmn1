package shpagintp.pkmn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shpagintp.pkmn.models.Student;
import shpagintp.pkmn.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{group}")
    public List<Student> getStudentsByGroup(@PathVariable String group) {
        return studentService.getStudentsByGroup(group);
    }

    @GetMapping("")
    public Student getStudentByFullName(@RequestParam String firstName,
                               @RequestParam String surName,
                               @RequestParam String familyName) {
        return studentService.getStudentByFullName(firstName, surName, familyName);
    }

    @PostMapping("")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
