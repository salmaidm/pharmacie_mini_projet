package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FournitureKey implements Serializable {

    @Column(name = "idProduit")
    private Integer idProduit;

    @Column(name = "idFournisseur")
    private Integer idFournisseur;
}

