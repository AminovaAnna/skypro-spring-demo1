package pro.sky.skyprospringdemo.service;

public interface PersonService {
//public String getPerson (Integer number);


    String getPersonByPassport(String passport);

    void addProfession(String passport, Integer profession);
}
