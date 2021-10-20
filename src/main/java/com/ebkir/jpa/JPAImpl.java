package com.ebkir.jpa;

import com.ebkir.datasource.User;
import com.ebkir.datasource.UserDatabase;

import java.util.List;

public class JPAImpl implements UserDatabase<User> {

    public JPAImpl() {

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
