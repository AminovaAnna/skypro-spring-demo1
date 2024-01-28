package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {
//public String getPerson (Integer number);


    List<Person> getPersonsByProfession(Integer professionNumber);

    List<Person> getPersonByProfessions(List<Integer> professionNumbers);

    String getPersonByPassport(String passport);

    String getProfessionNames(Set<Integer> professionNumbers);

    void addProfession(String passport, Integer profession);

    void addPerson(Person person);
}
