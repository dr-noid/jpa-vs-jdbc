package com.ebkir.jpa;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "User")
public class JpaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "JpaUser(My id is " + this.getId() + " and my firstname is " + this.getFirstName() + ")";
    }
}
