package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

//    @GetMapping(path = "/person")
//    public String getPersonInfo(@RequestParam("number") Integer number) {
//        try {
//            return personService.getPerson(number);
//        } catch (BadPersonNumberException e) {
//            return "Попробуйте другой номер";
//        } catch (Exception e){
//            return "Попробуйте в другой раз";
//
//        }
//    }

    @GetMapping(path = "/person/by-passport")
    public String getPersonInfo(@RequestParam("passport") String passport) {
        return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/profession/add")
    public String addProfession(@RequestParam("passport") String passport,
                                @RequestParam("profession") Integer profession) {
        personService.addProfession(passport, profession);
        return "Профессия успешно добавлена";
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surName") String surName,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer profession
    ) {
        Person person = new Person(
                name,
                surName,
                passport,
                profession
        );
        personService.addPerson(person);
        return "Person added";
    }

    @GetMapping(path = "/persons/by-profession")
    public String getByProfessions(@RequestParam("profession") int profession) {
        final List<Person> personsByProfession = personService.getPersonsByProfession(profession);
        final List<String> passports = new ArrayList<>();
        //    for (int i = 0; i < personsByProfession.size(); i++) { -один вариант (самый первый) прохода по коллекции
        //    Person person = personsByProfession.get(i);
//______________________________________________________
//        for (Person person : personsByProfession) {   - второй вариант replace with enhanced 'for'
//            passports.add(person.getPassport());
//        }

        final List<String> streamPassports = personsByProfession.stream()
                .map(e -> e.getPassport())
                .map(passport -> '*' + passport + '*')
                .collect(Collectors.toList());


        return streamPassports.toString();
    }


}
