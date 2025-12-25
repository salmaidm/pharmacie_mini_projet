package com.salma.mini_projet_pharmacie.pharmacie.dto;


import lombok.Data;

@Data
public class FournitureDTO {

    private Integer idProduit;
    private Integer idFournisseur;
    private Double prixAchat;
}