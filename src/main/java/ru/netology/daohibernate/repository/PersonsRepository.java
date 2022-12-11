package ru.netology.daohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons,PersonsId> {

    @Query("select p from Persons p where p.city_of_living = :city")
    List<Persons> findByCity_of_living(@Param("city") String city);

    List<Persons> findByIdAgeLessThanOrderByIdAge(Integer age);

    Optional<Persons> findByIdNameAndIdSurname(String name, String surname);

}
