package com.ebkir.jdbc;

import com.ebkir.jdbc.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private DatabaseProperties dbProps;

    public MySqlConnection() {
        this.dbProps = new DatabaseProperties();
    }

    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                this.dbProps.getConnectionString(), this.dbProps.getUsername(), this.dbProps.getPassword());
    }
}
