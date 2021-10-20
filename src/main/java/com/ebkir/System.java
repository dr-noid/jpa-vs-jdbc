package com.ebkir;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;
import com.ebkir.jdbc.JDBCImpl;

import java.sql.SQLException;

public class System {
    public static void main(String[] args) throws SQLException {

//        Database jpa = new JPAImpl();

        UserDatabase<User> jdbc = new JDBCImpl();
    }
}
