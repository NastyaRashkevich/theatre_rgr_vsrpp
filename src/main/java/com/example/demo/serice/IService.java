package com.example.demo.serice;

import java.util.List;

public interface IService<T> {
    void save(T t);

    List<T> findAll();

    T findById(Long id);

    void delete(Long id);

}
