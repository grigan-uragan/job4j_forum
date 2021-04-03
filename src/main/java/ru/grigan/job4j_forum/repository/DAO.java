package ru.grigan.job4j_forum.repository;

import java.util.List;

public interface DAO<T> {

    void save(T element);

    List<T> getAll();

    T findById(int id);

    void deleteById(int id);
}
