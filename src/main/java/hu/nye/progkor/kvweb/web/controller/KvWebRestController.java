package hu.nye.progkor.kvweb.web.controller;


import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.service.KaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/kave")
public class KvWebRestController {

    private final KaveService kaveService;

    @Autowired
    public KvWebRestController(KaveService kaveService) {
        this.kaveService = kaveService;
    }

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
