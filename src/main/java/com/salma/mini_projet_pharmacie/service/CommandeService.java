package com.salma.mini_projet_pharmacie.service;

import com.salma.mini_projet_pharmacie.model.*;
import com.salma.mini_projet_pharmacie.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ProduitRepository produitRepository) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
    }

    // Création commande
    public Commande creerCommande(Commande commande) {
        commande.setDateCommande(LocalDate.now());
        commande.setStatut("EN_ATTENTE");
        return commandeRepository.save(commande);
    }

    // Changement de statut + mise à jour stock
    public Commande changerStatut(Long id, String statut) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        commande.setStatut(statut);

        if ("LIVREE".equalsIgnoreCase(statut)) {
            for (LigneCommande lc : commande.getLignes()) {
                Produit produit = lc.getProduit();
                produit.setQuantiteStock(
                        produit.getQuantiteStock() + lc.getQuantite()
                );
                produitRepository.save(produit);
            }
        }
        return commandeRepository.save(commande);
    }
}
