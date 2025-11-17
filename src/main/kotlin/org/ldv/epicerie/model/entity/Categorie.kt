package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id_categorie: Long?,
    var nom_categorie: String,

    //Association Many to Many avec Produit
    @ManyToMany
    @JoinTable(
    name = "Categorie_Produit",
    joinColumns = [JoinColumn(name = "categorie_fkid")],
    inverseJoinColumns = [JoinColumn(name = "produit_fkid")]
    )
    var produits: MutableList<Produit> = mutableListOf()
    ) {
}