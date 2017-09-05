package com.quoders.apps.madridbus.domain.repository;


import io.reactivex.Observable;

public interface CloudRepository<T> {

    Observable<T> query();
}
