package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fourniture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fourniture {

    @EmbeddedId
    private FournitureKey id;

    @ManyToOne
    @MapsId("idProduit")
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne
    @MapsId("idFournisseur")
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;

    @Column(name = "prixAchat")
    private Double prixAchat;
}
