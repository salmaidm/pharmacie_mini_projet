package com.salma.mini_projet_pharmacie.mapper;

import com.salma.mini_projet_pharmacie.dto.CommandeDTO;
import com.salma.mini_projet_pharmacie.dto.LigneCommandeDTO;
import com.salma.mini_projet_pharmacie.model.Commande;
import com.salma.mini_projet_pharmacie.model.LigneCommande;
import com.salma.mini_projet_pharmacie.model.Produit;

import java.util.stream.Collectors;

public class CommandeMapper {

    // =========================
    // DTO -> ENTITY
    // =========================
    public static Commande toEntity(CommandeDTO dto) {

        Commande commande = new Commande();
        commande.setStatut(dto.getStatut());

        if (dto.getLignes() != null) {
            commande.setLignes(
                    dto.getLignes().stream().map(ligneDTO -> {

                        LigneCommande ligne = new LigneCommande();
                        ligne.setQuantiteDemande(ligneDTO.getQuantite());
                        ligne.setCommande(commande);

                        // On crée juste un Produit avec son ID
                        Produit produit = new Produit();
                        produit.setIdProduit(ligneDTO.getProduitId());
                        ligne.setProduit(produit);

                        return ligne;

                    }).collect(Collectors.toList())
            );
        }

        return commande;
    }

    // =========================
    // ENTITY -> DTO
    // =========================
    public static CommandeDTO toDTO(Commande commande) {

        CommandeDTO dto = new CommandeDTO();
        dto.setIdCommande(commande.getId());
        dto.setStatut(commande.getStatut());

        if (commande.getFournisseur() != null) {
            dto.setFournisseurId(
                    commande.getFournisseur().getIdFournisseur()
            );
        }

        if (commande.getLignes() != null) {
            dto.setLignes(
                    commande.getLignes().stream().map(ligne -> {

                        LigneCommandeDTO ligneDTO = new LigneCommandeDTO();
                        ligneDTO.setQuantite(ligne.getQuantiteDemande());

                        if (ligne.getProduit() != null) {
                            ligneDTO.setProduitId(
                                    ligne.getProduit().getIdProduit()
                            );
                        }

                        return ligneDTO;

                    }).collect(Collectors.toList())
            );
        }

        return dto;
    }
}
