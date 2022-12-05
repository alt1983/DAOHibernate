package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DaoHibernateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String name) {
        Query query = entityManager.createQuery("select p from Persons p where p.city_of_living =:city");
        query.setParameter("city", name);
        List<Persons> resultList = query.getResultList();
        System.out.println(resultList);
        return resultList;
    }


}
