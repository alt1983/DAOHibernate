package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.repository.DaoHibernateRepository;
import ru.netology.daohibernate.repository.Persons;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons/")
public class DaoHibernateController {

    private DaoHibernateRepository repository;

    public DaoHibernateController(DaoHibernateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("by-city")
    public List<Persons> getProductsNames(@RequestParam("name") String name) {
        List<Persons> res = repository.getPersonsByCity(name);
        return res;
    }

    @GetMapping("by-age")
    public List<Persons> getProductsAges(@RequestParam("age") Integer age) {
        List<Persons> res = repository.getPersonsByAge(age);
        return res;
    }

    @GetMapping("by-name-and-surname")
    public Optional<Persons> getProductsNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Optional<Persons> res = repository.getPersonsByNameAndSurname(name, surname);
        return res;
    }

}
