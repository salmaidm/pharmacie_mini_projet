package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.mapper.CommandeMapper;
import com.salma.mini_projet_pharmacie.model.Commande;
import com.salma.mini_projet_pharmacie.service.CommandeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping
    public CommandeDTO creerCommande(@RequestBody CommandeDTO dto) {
        Commande commande = commandeService.creerCommande(dto);
        return CommandeMapper.toDTO(commande);
    }

    @PutMapping("/{id}/statut")
    public Commande changerStatut(@PathVariable Integer id,
                                  @RequestParam String statut) {
        return commandeService.changerStatut(id, statut);
    }
}
