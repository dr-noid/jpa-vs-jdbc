package com.ebkir.datasource;

import java.sql.SQLException;
import java.util.List;

public interface UserDatabase<T> {

    void create(T t);

    List<T> read();

    void update(int id, T t);

    void remove(int id);
}
