package com.ebkir.jdbc;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCImpl implements UserDatabase<User> {

    private Connection connection;

    public JDBCImpl() throws SQLException {
        this.connection = new MySqlConnection().connect();
    }

    @Override
    public void create(User user) {
        String sql = "insert into User(firstname, lastname, age, dateOfBirth)\n" +
                "values(?, ?, ?, curdate());";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setInt(3, user.getAge());
            ps.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> read() {
        String sql = "select * from User";

        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet r = ps.executeQuery();

            while(r.next()) {
                users.add(new User(
                        r.getInt("id"),
                        r.getString("firstname"),
                        r.getString("lastname"),
                        r.getInt("age"),
                        r.getDate("dateOfBirth")
                ));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        String sql =
                "update User\n" +
                "set User.firstname = ?, User.lastname = ?, User.age = ?, User.dateOfBirth = curdate()\n" +
                "where User.id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getId());
            ps.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String sql =
                "delete from User where User.id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
