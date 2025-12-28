package com.salma.mini_projet_pharmacie.service;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.exception.ResourceNotFoundException;
import com.salma.mini_projet_pharmacie.mapper.CommandeMapper;
import com.salma.mini_projet_pharmacie.model.*;
import com.salma.mini_projet_pharmacie.repository.CommandeRepository;
import com.salma.mini_projet_pharmacie.repository.ProduitRepository;
import com.salma.mini_projet_pharmacie.repository.PharmacienRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final PharmacienRepository pharmacienRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ProduitRepository produitRepository,
                           PharmacienRepository pharmacienRepository) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.pharmacienRepository = pharmacienRepository;
    }

    // =========================
    // Création d'une commande
    // =========================
    public Commande creerCommande(CommandeDTO dto) {

        // Vérifier l'existence du pharmacien
        Pharmacien pharmacien = pharmacienRepository.findById(dto.getIdPharmacien())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pharmacien introuvable"));

        // Mapping DTO -> Entity
        Commande commande = CommandeMapper.toEntity(dto, pharmacien);

        // Logique métier INCHANGÉE
        commande.setDateCommande(LocalDate.now());
        commande.setStatut("EN_ATTENTE");

        return commandeRepository.save(commande);
    }

    // =========================
    // Changement de statut
    // + mise à jour du stock
    // =========================
    public Commande changerStatut(Long id, String statut) {

        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Commande non trouvée"));

        commande.setStatut(statut);

        // LOGIQUE IDENTIQUE à ton code initial
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
