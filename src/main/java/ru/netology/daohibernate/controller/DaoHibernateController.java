package ru.netology.daohibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured({"ROLE_READ"})
    public List<Persons> getProductsNames(@RequestParam("name") String name) {
        List<Persons> res = repository.getPersonsByCity(name);
        return res;
    }

    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    @GetMapping("by-age")
    public List<Persons> getProductsAges(@RequestParam("age") Integer age) {
        List<Persons> res = repository.getPersonsByAge(age);
        return res;
    }


    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("by-name-and-surname")
    public Optional<Persons> getProductsNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Optional<Persons> res = repository.getPersonsByNameAndSurname(name, surname);
        return res;
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("by-username-and-surname")
    public Optional<Persons> getProductsUsernameAndSurname(@RequestParam("username") String username, @RequestParam("surname") String surname) {
        Optional<Persons> res = repository.getPersonsByNameAndSurname(username, surname);
        return res;
    }

}
