package ru.netology.daohibernate.repository;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Persons {
    @EmbeddedId
    private PersonsId id;
    @Column(nullable = false)
    private String phone_number;
    @Column(nullable = false)
    private String city_of_living;

}
