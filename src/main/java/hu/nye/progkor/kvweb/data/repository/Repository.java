package hu.nye.progkor.kvweb.data.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T , I> {

    T save(T item);

    Optional<T> getById(I id);

    List<T> getAll();

    T update(T item);

    void deleteById(I id);

    int size();
}

