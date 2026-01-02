package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.mapper.CommandeMapper;
import com.salma.mini_projet_pharmacie.model.Commande;
import com.salma.mini_projet_pharmacie.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/{numCmd}/statut")
    public CommandeDTO changerStatut(@PathVariable Integer numCmd,
                                     @RequestBody CommandeDTO body) {
        Commande commande = commandeService.changerStatut(numCmd, body.getStatut());
        return CommandeMapper.toDTO(commande);
    }

    @GetMapping
    public List<CommandeDTO> getAllCommandes() {
        return commandeService.getAllCommandes()
                .stream()
                .map(CommandeMapper::toDTO)
                .toList();
    }


    // (optionnel mais utile pour le front bouton supprimer)
    @DeleteMapping("/{numCmd}")
    public void supprimer(@PathVariable Integer numCmd) {
        commandeService.supprimerCommande(numCmd);
    }
}
