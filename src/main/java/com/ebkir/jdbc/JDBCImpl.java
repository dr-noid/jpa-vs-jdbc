package com.ebkir.jdbc;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JDBCImpl implements UserDatabase<User> {

    private final Properties properties = new Properties();
    private Connection connection;

    public JDBCImpl() throws SQLException {
        this.connection = new MySqlConnection().connect();
    }

    @Override
    public void create(User user) {

    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }
}
