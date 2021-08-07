package Modules;

import java.time.LocalDate;

public class User {
    private String name;
    private int age;
    private boolean status;
    private LocalDate birthDate;

    public User(String name, int age, boolean status, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getStatus() {
        return this.status;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
