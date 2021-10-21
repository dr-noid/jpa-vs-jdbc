package com.ebkir.datasource;

import java.util.List;

public interface UserDatabase<T> {

    void create(T t);

    List<T> read();

    void update(T t);

    void remove(int id);
}
