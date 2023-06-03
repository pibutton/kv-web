package hu.nye.progkor.kvweb.service.impl;

import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.data.repository.Repository;
import hu.nye.progkor.kvweb.service.KaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Default implementation of {@link KaveService}.
 */
@Service
public class DefaultKaveService implements KaveService {

    private final Repository<Kave, Long> kaveRepository;

    @Autowired
    public DefaultKaveService(Repository<Kave, Long> kaveRepository) {
        this.kaveRepository = kaveRepository;
    }

    @Override
    public Kave createKave(Kave kave) { return kaveRepository.save(kave); }

    @Override
    public Optional<Kave> retrieveKaveById(Long id) {
        return kaveRepository.getById(id);
    }

    @Override
    public List<Kave> retrieveAllKavek() {
        return kaveRepository.getAll();
    }

    @Override
    public Kave updateKave(Kave kave) { return kaveRepository.update(kave); }

    @Override
    public void deleteKaveById(Long id) {
        kaveRepository.deleteById(id);
    }

}
