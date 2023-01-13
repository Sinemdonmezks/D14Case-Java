package com.sinem.repository;

import com.sinem.repository.entity.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHabitantRepository extends JpaRepository<Habitant, Long> {

    List<Habitant> findAllByIsCitizen(Boolean isCitizen);

    List<Habitant> findAllByNameSurname(String nameSurname);
    List<Habitant> findAllByNameSurnameContainingIgnoreCase(String nameSurname);

    List<Habitant> findAllByHasDrivingLicense(Boolean hasDrivingLicense);

    Optional<Habitant> findOptionalById(Long id);


    List<Habitant> findChildrenById(Long id);
}
