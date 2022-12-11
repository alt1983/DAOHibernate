package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DaoHibernateRepository {

    private final PersonsRepository personsRepository;

    public List<Persons> getPersonsByCity(String city_of_living){
        return personsRepository.findByCity_of_living(city_of_living);
    }

    public List<Persons> getPersonsByAge(Integer age){
        return personsRepository.findByIdAgeLessThanOrderByIdAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surname){
        return personsRepository.findByIdNameAndIdSurname(name, surname);
    }

}
