package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pharmacien")
@Getter
@Setter
@NoArgsConstructor
public class Pharmacien extends User {
}
