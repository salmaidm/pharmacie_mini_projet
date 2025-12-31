package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LigneCommande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "numCmd")
    private Commande commande;


    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // UN SEUL CHAMP
    @Column(name = "quantiteDemande")
    private Integer quantiteDemande;

    // (si tu veux aussi quantite LIVRÉE, change le nom)
    // @Column(name = "quantiteLivree")
    // private Integer quantiteLivree;

    // ===== GETTERS & SETTERS =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantiteDemande() {
        return quantiteDemande;
    }

    public void setQuantiteDemande(Integer quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }
}
