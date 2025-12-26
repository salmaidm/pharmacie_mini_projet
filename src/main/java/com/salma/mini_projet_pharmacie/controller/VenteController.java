package com.pharmacie.controller;

import com.pharmacie.dto.VenteDTO;
import com.pharmacie.service.VenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventes")
public class VenteController {

    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @PostMapping
    public VenteDTO creer(@RequestBody VenteDTO dto) {
        return venteService.enregistrerVente(dto);
    }

    @GetMapping("/client/{id}")
    public List<VenteDTO> ventesClient(@PathVariable Long id) {
        return venteService.ventesParClient(id);
    }
}
