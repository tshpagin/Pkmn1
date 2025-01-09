package shpagintp.pkmn.models;

import lombok.*;
import shpagintp.pkmn.entities.StudentEntity;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;

    private String firstName;

    private String surName;

    private String familyName;

    private String group;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public static Student convertToStudent(StudentEntity studentEntity) {
        return Student.builder()
                .id(studentEntity.getId())
                .firstName(studentEntity.getFirstName())
                .surName(studentEntity.getSurName())
                .familyName(studentEntity.getFamilyName())
                .group(studentEntity.getGroup())
                .build();
    }
}
