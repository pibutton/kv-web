package hu.nye.progkor.kvweb.data.repository.impl;

import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InMemoryKaveRepository implements Repository<Kave, Long> {

    private static final Map<Long, Kave> STORAGE = new HashMap<>();

    @Override
    public Kave save(Kave kave) {
        Long id = STORAGE.size() + 1L;
        kave.setId(id);
        STORAGE.put(id, kave);
        return STORAGE.get(id);
    }

    @Override
    public Optional<Kave> getById(Long id) {
        return Optional.ofNullable(STORAGE.get(id));
    }

    @Override
    public List<Kave> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Kave update(Kave kave) {
        Long id = kave.getId();
        STORAGE.put(id, kave);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }

    @Override
    public int size() {
        return STORAGE.size();
    }

}
