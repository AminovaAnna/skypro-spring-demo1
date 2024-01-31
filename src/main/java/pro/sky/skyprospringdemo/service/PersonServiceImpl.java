package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
    Map<String, Person> persons = new HashMap<>(Map.of(
            "12345",
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    2),
            "54321",
            new Person(
                    "Люк",
                    "Бессон",
                    "54321",
                    3),
            "41232",
            new Person(
                    "Жерар",
                    "Депардье",
                    "41232",
                    0),
            "928374",
            new Driver(
                    "Джейсон",
                    "Стетхем",
                    "928374",
                    "3491",
                    1),
            "1000",
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "1000",
                    "2345",
                    2)
    ));

    String[] professions = {
            "безработный",
            "водитель",
            "плотник",
            "столяр",
            "актер"
    };

    Map<String, Integer> professionsCodes = Map.of(
            "безработный", 0,
            "водитель", 1,
            "плотник", 2,
            "столяр", 3,
            "актер", 4
    );

    public List<Person> getPersonsByProfession(Integer professionNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().contains(professionNumber)) {
                result.add(person);
            }
        }
        return result;
    }
@Override
    public List<Person> getPersonByProfessions(List<Integer> professionNumbers){
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().containsAll(professionNumbers)){
                result.add(person);
            }
        }
        return result;
    }


    //   @Override
//    public String getPerson(Integer number) {
//        final Person person;
//        if (number >= persons.size()) {
//            throw new BadPersonNumberException();
//        }
//        person = persons.get(number);
//        final String personDescription = ""
//                + person.getName() + " "
//                + person.getSurname() + " "
//                + person.getPassport() + " "
//                + professions[person.getProfessionNumber()];
//        return personDescription;
//    }

    @Override

    public String getPersonByPassport(String passport) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport() + " "
                + getProfessionNames(person.getProfessionNumbers());
        return personDescription;
    }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        String result = "";
        for (Integer professionNumber : professionNumbers) {
            result = result + " " + professions[professionNumber];
        }
        return result;
    }

    @Override
    public void addProfession(String passport, Integer profession) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        person.getProfessionNumbers().add(profession);
    }


}


