package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.model.Ordonnance;
import com.salma.mini_projet_pharmacie.service.OrdonnanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordonnances")
public class OrdonnanceController {

    private final OrdonnanceService ordonnanceService;

    public OrdonnanceController(OrdonnanceService ordonnanceService) {
        this.ordonnanceService = ordonnanceService;
    }

    @PostMapping
    public Ordonnance creerOrdonnance(@RequestBody Ordonnance ordonnance) {
        return ordonnanceService.enregistrerOrdonnance(ordonnance);
    }
    @GetMapping("/client/{id}")
    public List<Ordonnance> ordonnancesParClient(@PathVariable Integer id) {
        return ordonnanceService.getOrdonnancesByClient(id);
    }
}
