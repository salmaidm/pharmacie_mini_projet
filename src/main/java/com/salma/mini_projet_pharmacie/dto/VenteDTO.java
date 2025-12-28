package com.salma.mini_projet_pharmacie.dto;

import java.time.LocalDate;

public class VenteDTO {

    private Integer idVente;
    private int quantite;
    private LocalDate dateVente;

    private Integer clientId;
    private Integer produitId;
    private Integer ordonnanceId;

    private double prixTotal;

    public Integer getIdVente() { return idVente; }
    public void setIdVente(Integer idVente) { this.idVente = idVente; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public LocalDate getDateVente() { return dateVente; }
    public void setDateVente(LocalDate dateVente) { this.dateVente = dateVente; }

    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public Integer getProduitId() { return produitId; }
    public void setProduitId(Integer produitId) { this.produitId = produitId; }

    public Integer getOrdonnanceId() { return ordonnanceId; }
    public void setOrdonnanceId(Integer ordonnanceId) { this.ordonnanceId = ordonnanceId; }

    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }
}
