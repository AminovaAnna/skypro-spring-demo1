package pro.sky.skyprospringdemo.domain;

public class TruckDriver extends Driver {
    public TruckDriver(String name, String surname, String passport, String driverLicenseNumber) {
        super(name, surname, passport, driverLicenseNumber);
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        if (driverLicenseNumber != null && driverLicenseNumber.startsWith("2")) {
            super.setDriverLicenseNumber(driverLicenseNumber);
        }
    }

}
