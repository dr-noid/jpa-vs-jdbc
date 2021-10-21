package com.ebkir.jdbc;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

    private final Properties properties = new Properties();
    private final String connectionString;
    private final String username;
    private final String password;

    public DatabaseProperties() {
        try {
            this.properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        this.connectionString = this.properties.getProperty("connectionstring");
        this.username = this.properties.getProperty("username");
        this.password = this.properties.getProperty("password");
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
