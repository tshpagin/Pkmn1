package shpagintp.pkmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shpagintp.pkmn.entities.CardEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardEntityRepository extends JpaRepository<CardEntity, UUID> {

    Optional<CardEntity> findByName(String name);

    Optional<CardEntity> findByPokemonOwner_FirstNameAndPokemonOwner_SurNameAndPokemonOwner_FamilyName(String firstName, String surName, String familyName);

    boolean existsByName(String name);
}
