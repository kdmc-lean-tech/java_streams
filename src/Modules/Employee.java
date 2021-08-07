package Modules;

import enums.Position;

import java.time.LocalDate;

public class Employee extends User {
    private String company;
    private Position position;
    private double salary;

    public Employee(
            String name,
            int age,
            boolean status,
            LocalDate birthDate,
            String company,
            Position position,
            double salary
    ) {
        super(name, age, status, birthDate);
        this.company = company;
        this.position = position;
        this.salary = salary;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public Position getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}
