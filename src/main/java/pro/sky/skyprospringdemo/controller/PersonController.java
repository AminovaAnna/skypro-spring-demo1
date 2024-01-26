package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.service.PersonService;

import java.util.List;

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

    public void getByProfessions() {
        personService.getPersonByProfessions(List.of(1, 3));
    }


}
