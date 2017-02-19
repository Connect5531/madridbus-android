package com.quoders.apps.madridbus.domain.repository;


import java.util.List;

public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    List<T> query();

/*    void remove(Specification specification);

    List<T> query(Specification specification);*/
}
