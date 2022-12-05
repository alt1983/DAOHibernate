CREATE TABLE PERSONS
(
    name           VARCHAR(30) NOT NULL,
    surname        VARCHAR(30) NOT NULL,
    age            int         NOT NULL DEFAULT 0,
    phone_number   VARCHAR(15) NOT NULL,
    city_of_living VARCHAR(30) NOT NULL,
    PRIMARY KEY (name, surname, age)
);