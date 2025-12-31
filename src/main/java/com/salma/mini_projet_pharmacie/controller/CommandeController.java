package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.mapper.CommandeMapper;
import com.salma.mini_projet_pharmacie.model.Commande;
import com.salma.mini_projet_pharmacie.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // =========================
    // Création commande
    // =========================
    @PostMapping
    public CommandeDTO creerCommande(@RequestBody CommandeDTO dto) {
        Commande commande = commandeService.creerCommande(dto);
        return CommandeMapper.toDTO(commande);
    }

    // =========================
    // Changer statut
    // =========================
    @PutMapping("/{id}/statut")
    public CommandeDTO changerStatut(@PathVariable Integer id,
                                     @RequestParam String statut) {
        Commande commande = commandeService.changerStatut(id, statut);
        return CommandeMapper.toDTO(commande);
    }
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }
}
