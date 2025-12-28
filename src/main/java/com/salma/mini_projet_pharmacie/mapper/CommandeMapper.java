package com.salma.mini_projet_pharmacie.mapper;

import com.salma.mini_projet_pharmacie.dto.*;
import com.salma.mini_projet_pharmacie.model.*;

import java.util.stream.Collectors;

public class CommandeMapper {

    public static Commande toEntity(CommandeDTO dto, Pharmacien pharmacien) {

        Commande commande = new Commande();
        commande.setStatut(dto.getStatut());
        commande.setPharmacien(pharmacien);

        commande.setLignes(
                dto.getLignes().stream().map(ligneDTO -> {

                    LigneCommande ligne = new LigneCommande();
                    ligne.setQuantite(ligneDTO.getQuantite());
                    ligne.setQuantiteDemande(ligneDTO.getQuantiteDemande());
                    ligne.setCommande(commande);

                    Produit produit = new Produit();
                    produit.setIdProduit(ligneDTO.getIdProduit());
                    ligne.setProduit(produit);

                    return ligne;

                }).collect(Collectors.toList())
        );

        return commande;
    }

    public static CommandeDTO toDTO(Commande commande) {

        CommandeDTO dto = new CommandeDTO();
        dto.setNumCmd(commande.getId());
        dto.setStatut(commande.getStatut());

        return dto;
    }
}
