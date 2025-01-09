package shpagintp.pkmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shpagintp.pkmn.entities.StudentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, UUID> {

    Optional<StudentEntity> findStudentByFirstNameAndSurNameAndFamilyName(String firstName, String surName, String familyName);

    List<StudentEntity> findStudentsByGroup(String group);

    boolean existsByFirstNameAndSurNameAndFamilyName(String firstName, String surName, String familyName);
}
