package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.dto.VenteDTO;
import com.salma.mini_projet_pharmacie.service.VenteService;
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
    public List<VenteDTO> ventesClient(@PathVariable Integer id) {
        return venteService.ventesParClient(id);
    }
}
