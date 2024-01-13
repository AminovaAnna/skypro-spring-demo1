package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;

import java.util.Arrays;

@Service
public class PersonServiceImpl implements PersonService {
    Person[] persons = {
            new Person(
                    "Жан",
                    "Рено",
                    "12345"
            ),
            new Person(
                    "Люк",
                    "Бессон",
                    "54321"
            ),
            new Person(
                    "Жерар",
                    "Депардье",
                    "41232"
            ),
            new Driver(
                    "Джейсон",
                    "Стетхем",
                    "928374",
                    "3491"
            ),
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "1000",
                    "2345"
            ),
    };


    @Override
    public String getPerson(Integer number) {
        final Person person;
                person = persons[number];
                final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport();
        return personDescription;
    }


}
