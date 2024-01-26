package pro.sky.skyprospringdemo.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private String surname;
    private String passport;
    private Set<Integer> professionNumbers;

    public Person(String name, String surname, String passport, int professionNumber) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.professionNumbers = new HashSet<>(List.of(professionNumber));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Set<Integer> getProfessionNumbers() {
        return professionNumbers;
    }


    public void setProfessionNumbers(Set<Integer> professionNumbers) {
        this.professionNumbers = professionNumbers;
    }
}
