package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    List<Person> persons = List.of(
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    2),
            new Person(
                    "Люк",
                    "Бессон",
                    "54321",
                    3),
            new Person(
                    "Жерар",
                    "Депардье",
                    "41232",
                    0),
            new Driver(
                    "Джейсон",
                    "Стетхем",
                    "928374",
                    "3491",
                    1),
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "1000",
                    "2345",
                    4)
            );

    String[] professions = {
            "безработный",
            "водитель",
            "плотник",
            "столяр"
    };


    @Override
    public String getPerson(Integer number) {
        final Person person;
        if (number >= persons.length){
            throw new BadPersonNumberException();
        }
        person = persons[number];
        final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport() + " "
                + professions[person.getProfessionNumber()] ;
        return personDescription;
    }


}
