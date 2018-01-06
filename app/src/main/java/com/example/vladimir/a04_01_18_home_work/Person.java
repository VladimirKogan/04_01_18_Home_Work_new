package com.example.vladimir.a04_01_18_home_work;

/**
 * Created by vladimir on 06/01/2018.
 */

public class Person {
    private String name, phone, email, description;

    public Person() {
    }

    public Person(String name, String phone, String email, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return this.name + "," + this.phone + "," + this.email + "," + this.description + ";";
    }
}
