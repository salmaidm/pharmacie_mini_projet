package com.pharmacie.controller;

import com.pharmacie.model.Ordonnance;
import com.pharmacie.service.OrdonnanceService;
import org.springframework.web.bind.annotation.*;

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
}
