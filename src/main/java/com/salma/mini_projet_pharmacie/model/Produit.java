package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private Integer idProduit;

    @Column(name = "nomCommercial")
    private String nomCommercial;

    @Column(name = "composition")
    private String composition;

    @Column(name = "prixP")
    private Double prixP;

    @Column(name = "formPharmaceutique")
    private String formPharmaceutique;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "datePeremption")
    private Date datePeremption;

    @Column(name = "quantiteStock")
    private Integer quantiteStock;

    @OneToMany(mappedBy = "produit")
    private List<Fourniture> fournitures;
}
