package shpagintp.pkmn.dao;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import shpagintp.pkmn.entities.StudentEntity;
import shpagintp.pkmn.models.Student;
import shpagintp.pkmn.repository.StudentEntityRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final StudentEntityRepository studentEntityRepository;

    @SneakyThrows
    public List<Student> findAll() {
        return studentEntityRepository.findAll()
                .stream()
                .map(Student::convertToStudent)
                .toList();
    }

    @SneakyThrows
    public Student findByFullName(String firstName, String surName, String familyName) {
        return Student.convertToStudent(studentEntityRepository.findStudentByFirstNameAndSurNameAndFamilyName(firstName, surName, familyName).orElseThrow(
                () -> new UserPrincipalNotFoundException("Student with FIO" + firstName + "," + surName + ", " + familyName + " not found")
        ));
    }

    @SneakyThrows
    public List<Student> findStudentsByGroup(String group) {
        return studentEntityRepository.findStudentsByGroup(group)
                .stream()
                .map(Student::convertToStudent)
                .toList();
    }

    @SneakyThrows
    public Student save(Student student) {
        return Student.convertToStudent(studentEntityRepository.save(StudentEntity.convertFromStudent(student)));
    }

    public boolean studentExists(Student student) {
        return studentEntityRepository.existsByFirstNameAndSurNameAndFamilyName(
                student.getFirstName(),
                student.getSurName(),
                student.getFamilyName()
        );
    }
}
