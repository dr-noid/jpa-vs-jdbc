package com.ebkir;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;
import com.ebkir.jdbc.JDBCImpl;

import java.sql.SQLException;
import java.util.Date;

public class JpaJdbcTest {

    private static final User user = new User("firstname", "lastname", 33, new Date());

    public static void main(String[] args) throws SQLException {
        UserDatabase<User> jdbc = new JDBCImpl();

        jdbc.create(user);
//        jpa.create();

        System.out.println(jdbc.read());
//        jpa.read();

        jdbc.update();
//        jdbc.update()

        jdbc(user);
        jpa(user);
    }

    public static void jpa(User user) {
//        Database jpa = new JPAImpl();
    }
}
