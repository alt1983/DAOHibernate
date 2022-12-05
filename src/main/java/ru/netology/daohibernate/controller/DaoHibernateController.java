package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.repository.DaoHibernateRepository;
import ru.netology.daohibernate.repository.Persons;

import java.util.List;

@RestController
@RequestMapping("/persons/")
public class DaoHibernateController {

    private DaoHibernateRepository repository;

    public DaoHibernateController(DaoHibernateRepository repository) {
        this.repository = repository;
    }


    @GetMapping("by-city")
    public List<Persons> getProductNames(@RequestParam("name") String name) {
        List<Persons> res = repository.getPersonsByCity(name);
        return res;
    }

}
