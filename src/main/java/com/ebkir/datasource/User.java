package com.ebkir.datasource;

import java.util.Date;
import java.util.UUID;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private Date dateOfBirth;
    private String uuid;

    public User(String firstname, String lastname, int age, Date dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.uuid = UUID.randomUUID().toString();
    }
    public User(int id, String firstname, String lastname, int age, Date dateOfBirth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.uuid = UUID.randomUUID().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "User(My id is " + this.getId() + " and my UUID is " + this.getUuid() + ")";
    }
}
