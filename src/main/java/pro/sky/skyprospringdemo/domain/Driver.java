package pro.sky.skyprospringdemo.domain;

public class Driver extends Person {
    private String driverLicenseNumber;

    public Driver(String name, String surname, String passport, String driverLicenseNumber) {
        super(name, surname, passport);
        this.driverLicenseNumber = driverLicenseNumber;
    }


    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
