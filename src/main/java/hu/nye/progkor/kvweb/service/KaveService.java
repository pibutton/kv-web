package hu.nye.progkor.kvweb.service;

import hu.nye.progkor.kvweb.data.model.Kave;

import java.util.List;
import java.util.Optional;

/**
 * A service kavek-at kezelhessunk a kvweben.
 */
public interface KaveService {

    Kave createKave(Kave kave);

    Optional<Kave> retrieveKaveById(Long id);

    List<Kave> retrieveAllKavek();

    Kave updateKave(Kave kave);

    void deleteKaveById(Long id);

}
