package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private String birthDate;
    private int age;
    private String phoneNumber;

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("name can not be blank/null.");
        }
        if (phoneNumber.isBlank() || phoneNumber == null || phoneNumber.length() < 5) {
            throw new IllegalArgumentException(
                    "phoneNumber can not be null or blank. And atleast five characters must be present in phone number.");
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

        this.age = toAge(birthDate);

    }

    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        Date date = formatter.parse(birthDate);
        long timemilli1 = date.getTime();
        long timemilli2 = new Date().getTime();

        long diff = timemilli2 - timemilli1;
        long days = TimeUnit.MILLISECONDS.toDays(diff);

        int age = (int) (days / 365);
        return age;
    }

    private void setAge(int age) throws ParseException {
        this.age = age;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public void setName(String name) {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("name can not be blank/null.");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.isBlank() || phoneNumber == null || phoneNumber.length() < 5) {
            throw new IllegalArgumentException(
                    "phoneNumber can not be null or blank. And atleast five characters must be present in phone number.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        String temp = "Name: " + this.name + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "Birth Date: " + this.birthDate + "\n" +
                "Age: " + this.age + " year old\n";

        return temp;

    }

}
