package ru.avalon.devj.repo;

import ru.avalon.devj.model.Domain;
import ru.avalon.devj.model.Person;

import java.util.List;

public interface IRepository {
    List<Person> getPersons();
    Person getPersonById(int id);
    List<Domain> getDomains();
    List<Domain> getDomainByPerson(Person person);
}
