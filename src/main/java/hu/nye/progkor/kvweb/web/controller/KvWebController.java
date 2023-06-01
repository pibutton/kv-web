package hu.nye.progkor.kvweb.web.controller;

import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.service.KaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kave-web")
public class KvWebController {

    private final KaveService kaveService;

    @Autowired
    public KvWebController(KaveService kaveService) {
        this.kaveService = kaveService;
    }

    @GetMapping("/{id}")
    public String getKaveById(Model model, @PathVariable Long id) {
        Optional<Kave> optionalKave = kaveService.retrieveKaveById(id);
        return optionalKave.map(kave -> {
            model.addAttribute("kave", kave);
            return "kave-web/edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "kave-web/" + id);
            return "kave-web/notFound";
        });
    }

    @GetMapping
    public String getAllKavek(Model model) {
        List<Kave> allKavek = kaveService.retrieveAllKavek();
        model.addAttribute("kavek", allKavek);
        return "kave-web/list";
    }

    @GetMapping("/create")
    public String createKave() {
        return "kave-web/create";
    }

    @PostMapping("/create")
    public String createKave(Model model, Kave kave) {
        Kave ujKave = kaveService.createKave(kave);
        model.addAttribute("kave", ujKave);
        return "kave-web/edit";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateKave(Model model, Kave kave) {
        Kave updatedKave = kaveService.updateKave(kave);
        model.addAttribute("kave", updatedKave);
        return "kave-web/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteKaveById(Model model, @PathVariable Long id) {
        kaveService.deleteKaveById(id);
        List<Kave> allKavek = kaveService.retrieveAllKavek();
        model.addAttribute("kavek", allKavek);
        return "kave-web/list";
    }


}
