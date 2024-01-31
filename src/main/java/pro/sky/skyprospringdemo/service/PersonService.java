package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Person;

import java.util.List;

public interface PersonService {
//public String getPerson (Integer number);


    List<Person> getPersonByProfessions(List<Integer> professionNumbers);

    String getPersonByPassport(String passport);

    void addProfession(String passport, Integer profession);

    void addPerson(Person person);
}
