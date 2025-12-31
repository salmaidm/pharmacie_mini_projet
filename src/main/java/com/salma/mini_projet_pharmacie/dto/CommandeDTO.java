package com.salma.mini_projet_pharmacie.dto;

import java.util.List;

public class CommandeDTO {

    private Integer idCommande;
    private Integer fournisseurId;   // ✅ AJOUTÉ
    private String statut;

    private List<LigneCommandeDTO> lignes;

    // ===== GETTERS & SETTERS =====

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Integer fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<LigneCommandeDTO> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeDTO> lignes) {
        this.lignes = lignes;
    }
}
