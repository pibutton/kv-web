package hu.nye.progkor.kvweb.data.repository;

import java.util.List;
import java.util.Optional;

/**
 * A generic interface for managing entities in a repository.
 *
 * @param <T> the type of the entity
 * @param <I> the type of the entity's identifier
 */
public interface Repository<T, I> {

    T save(T item);

    Optional<T> getById(I id);

    List<T> getAll();

    T update(T item);

    void deleteById(I id);

    int size();
}

