package com.salma.mini_projet_pharmacie.pharmacie.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "fournisseur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFournisseur")
    private Integer idFournisseur;

    @Column(name = "nomFournisseur")
    private String nomFournisseur;

    @Column(name = "tel")
    private String tel;

    @OneToMany(mappedBy = "fournisseur")
    private List<Fourniture> fournitures;
}
