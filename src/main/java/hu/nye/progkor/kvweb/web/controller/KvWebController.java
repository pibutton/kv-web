package hu.nye.progkor.kvweb.web.controller;

import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.service.KaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * Controller for the kave-web.
 */
@Controller
@RequestMapping("/kave-web")
public class KvWebController {

    private final KaveService kaveService;

    @Autowired
    public KvWebController(KaveService kaveService) {
        this.kaveService = kaveService;
    }

    /**
     * Shows the kave editor screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the kave to retrieve
     * @return the name of the edit view to render
     */
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

    /**
     * Shows the kave list screen.
     *
     * @param model the model object to store attributes
     * @return the name of the kave list view to render
     */
    @GetMapping
    public String getAllKavek(Model model) {
        List<Kave> allKavek = kaveService.retrieveAllKavek();
        model.addAttribute("kavek", allKavek);
        return "kave-web/list";
    }

    /**
     * Shows the kave creation screen.
     *
     * @return the name of the kave creation view to render
     */
    @GetMapping("/create")
    public String createKave() {
        return "kave-web/create";
    }

    /**
     * Creates a new kave.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param kave the kave object to create
     * @return the name of the edit view to render
     */
    @PostMapping("/create")
    public String createKave(Model model, Kave kave) {
        Kave ujKave = kaveService.createKave(kave);
        model.addAttribute("kave", ujKave);
        return "kave-web/edit";
    }

    /**
     * Updates an existing kave.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param kave the kave object to update
     * @return the name of the edit view to render
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateKave(Model model, Kave kave) {
        Kave updatedKave = kaveService.updateKave(kave);
        model.addAttribute("kave", updatedKave);
        return "kave-web/edit";
    }

    /**
     * Deletes a kave by ID.
     * Also navigates back to the kave list screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the kave to delete
     * @return the name of the kave list view to render
     */
    @GetMapping("/{id}/delete")
    public String deleteKaveById(Model model, @PathVariable Long id) {
        kaveService.deleteKaveById(id);
        List<Kave> allKavek = kaveService.retrieveAllKavek();
        model.addAttribute("kavek", allKavek);
        return "kave-web/list";
    }


}
