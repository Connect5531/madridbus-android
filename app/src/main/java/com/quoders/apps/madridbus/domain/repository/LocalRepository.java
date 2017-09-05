package com.quoders.apps.madridbus.domain.repository;


import io.reactivex.Observable;

public interface LocalRepository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    Observable<T> query();

    Observable<Iterable<T>> queryItems();

    void close();
}
