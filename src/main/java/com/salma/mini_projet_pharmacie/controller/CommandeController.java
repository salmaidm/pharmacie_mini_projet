package com.salma.mini_projet_pharmacie.controller;

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
    public Commande creerCommande(@RequestBody Commande commande) {
        return commandeService.creerCommande(commande);
    }

    @PutMapping("/{id}/statut")
    public Commande modifierStatut(@PathVariable Long id,
                                   @RequestParam String statut) {
        return commandeService.changerStatut(id, statut);
    }

}
