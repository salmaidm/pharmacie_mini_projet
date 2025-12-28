package com.salma.mini_projet_pharmacie.dto;

import java.util.List;

public class CommandeDTO {

    private Integer numCmd;
    private String statut;
    private Integer idPharmacien;
    private List<LigneCommandeDTO> lignes;

    public Integer getNumCmd() {
        return numCmd;
    }

    public void setNumCmd(Integer numCmd) {
        this.numCmd = numCmd;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getIdPharmacien() {
        return idPharmacien;
    }

    public void setIdPharmacien(Integer idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    public List<LigneCommandeDTO> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeDTO> lignes) {
        this.lignes = lignes;
    }
}
