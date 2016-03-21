package fourthHomework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class Employee {

    private String name;
    private String surname;
    private String middleName;
    private int workAge;

    @Override
    public String toString() {
        return " ФИО " + surname +
                " " + name +
                " " + middleName +
                ", стаж работы " + workAge + "\n";
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }


    public Collection printEmployee(Collection employees, int workAge) {

        return employees;
    }


}
