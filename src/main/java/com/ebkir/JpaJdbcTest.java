package com.ebkir;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;
import com.ebkir.jdbc.JDBCImpl;
import com.ebkir.jpa.JPAImpl;
import com.ebkir.jpa.JpaUser;

import java.sql.SQLException;
import java.util.Date;

public class JpaJdbcTest {

    public static void main(String[] args) throws SQLException {
        jdbc();
        jpa();
    }

    public static void jpa() {
        UserDatabase<JpaUser> jpaDatabase = new JPAImpl();
        JpaUser jpaUser = new JpaUser();

        jpaUser.setFirstName("firstname");
        jpaUser.setLastname("lastname");
        jpaUser.setAge(19);
        jpaUser.setDateOfBirth(new Date());

        jpaDatabase.create(jpaUser);

        System.out.println(jpaDatabase.read());
    }

    public static void jdbc() throws SQLException {
        UserDatabase<User> jdbc = new JDBCImpl();

        User USER = new User("firstname", "lastname", 33, new Date());
        User USER2 = new User("testuser2", "testlastname2", 22, new Date());
        User UPDATED_USER = new User(1, "updatedfirstname",
                "updatedlastname", 44, new Date());

        System.out.println("Adding test users to JDBCDatabase");
        jdbc.create(USER);
        jdbc.create(USER2);

        System.out.println("\nGetting all users from JDBCDatabase...");
        jdbc.read().forEach(System.out::println);

        System.out.println("\nupdating JDBCDatabase...");
        jdbc.update(1, UPDATED_USER);
        System.out.println("\nJDBC Updated Users: ");
        jdbc.read().forEach(System.out::println);

        System.out.println("\nRemoving user from JDBCDatabase...");
        jdbc.remove(1);

        System.out.println("\nRemaining JDBC users:");
        System.out.println(jdbc.read());
    }
}
