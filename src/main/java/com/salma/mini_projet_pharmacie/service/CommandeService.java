package com.salma.mini_projet_pharmacie.service;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.exception.ResourceNotFoundException;
import com.salma.mini_projet_pharmacie.mapper.CommandeMapper;
import com.salma.mini_projet_pharmacie.model.*;
import com.salma.mini_projet_pharmacie.repository.CommandeRepository;
import com.salma.mini_projet_pharmacie.repository.FournisseurRepository;
import com.salma.mini_projet_pharmacie.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ProduitRepository produitRepository,
                           FournisseurRepository fournisseurRepository) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    // =========================
    // Création commande (DTO)
    // =========================
    public Commande creerCommande(CommandeDTO dto) {

        if (dto.getFournisseurId() == null) {
            throw new RuntimeException("ID Fournisseur manquant");
        }

        Fournisseur fournisseur = fournisseurRepository
                .findById(dto.getFournisseurId())
                .orElseThrow(() ->
                        new RuntimeException("Fournisseur introuvable"));

        Commande commande = CommandeMapper.toEntity(dto);
        commande.setFournisseur(fournisseur);

        for (LigneCommande ligne : commande.getLignes()) {

            if (ligne.getProduit() == null ||
                    ligne.getProduit().getIdProduit() == null) {
                throw new RuntimeException("Produit manquant");
            }

            Produit produit = produitRepository
                    .findById(ligne.getProduit().getIdProduit())
                    .orElseThrow(() ->
                            new RuntimeException("Produit introuvable"));

            ligne.setProduit(produit);
            ligne.setCommande(commande);
        }

        return commandeRepository.save(commande);
    }


    // =========================
    // Changement de statut
    // =========================
    public Commande changerStatut(Integer numCmd, String statut) {

        Commande commande = commandeRepository.findById(numCmd)

                .orElseThrow(() ->
                        new ResourceNotFoundException("Commande non trouvée"));

        commande.setStatut(statut);

        // Mise à jour stock si livrée
        if ("LIVREE".equalsIgnoreCase(statut)) {
            for (LigneCommande lc : commande.getLignes()) {
                Produit produit = lc.getProduit();
                produit.setQuantiteStock(
                        produit.getQuantiteStock() + lc.getQuantiteDemande()
                );
                produitRepository.save(produit);
            }
        }

        return commandeRepository.save(commande);
    }
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
    public void supprimerCommande(Integer numCmd) {
        Commande cmd = commandeRepository.findById(numCmd)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        commandeRepository.delete(cmd);
    }
}
