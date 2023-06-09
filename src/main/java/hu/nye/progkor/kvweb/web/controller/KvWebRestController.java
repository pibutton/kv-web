package hu.nye.progkor.kvweb.web.controller;


import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.service.KaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * A REST controller for managing kavek in the kv-web.
 */
@RestController
@RequestMapping("/api/v1/kave")
public class KvWebRestController {

    private final KaveService kaveService;

    @Autowired
    public KvWebRestController(KaveService kaveService) {
        this.kaveService = kaveService;
    }

    /**
     * Returns a kave with the given id.
     *
     * @param id the id of the kave to retrieve
     * @return a kave objektumot
     */
    @GetMapping("/{id}")
    public ResponseEntity<Kave> getKaveById(@PathVariable Long id) {
        Optional<Kave> kave = kaveService.retrieveKaveById(id);
        return kave.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Kave> getAllKavek() {
        return kaveService.retrieveAllKavek();
    }

    @PostMapping
    public Kave createKave(@RequestBody Kave kave) {
        return kaveService.createKave(kave);
    }

    @PutMapping
    public Kave updateKave(@RequestBody Kave kave) {
        return kaveService.updateKave(kave);
    }

    @DeleteMapping("/{id}")
    public void deleteKaveById(@PathVariable Long id) {
        kaveService.deleteKaveById(id);
    }

}
