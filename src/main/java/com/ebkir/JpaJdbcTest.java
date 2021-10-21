package com.ebkir;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;
import com.ebkir.jdbc.JDBCImpl;

import java.sql.SQLException;
import java.util.Date;

public class JpaJdbcTest {

    private static final User user = new User("firstname", "lastname", 33, new Date());
    private static final User user2 = new User("testuser2", "testlastname2", 22, new Date());
    private static final User updatedUser = new User(1, "updatedfirstname",
            "updatedlastname", 44, new Date());

    public static void main(String[] args) throws SQLException {
        UserDatabase<User> jdbc = new JDBCImpl();

        System.out.println("Adding test users to databases...");
        jdbc.create(user);
        jdbc.create(user2);
//        jpa.create();

        System.out.println("\nGetting all users from JDBCDatabase...");
        jdbc.read().forEach(System.out::println);
        System.out.println("\nGetting all users from JPADatabase: ");
//        jpa.read();

        System.out.println("\nupdating JDBCDatabase...");
        jdbc.update(updatedUser);
        System.out.println("\nJDBC Updated Users: ");
        jdbc.read().forEach(System.out::println);
//        jdbc.update()

        System.out.println("\nRemoving user from databases...");
        jdbc.remove(1);

        System.out.println("\nRemaining JDBC users:");
        System.out.println(jdbc.read());

    }

    public static void jpa(User user) {
//        Database jpa = new JPAImpl();
    }
}
