package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id_categorie: Long?=null,
    var nom_categorie: String,

    //Association Many to Many avec Produit
    @ManyToMany(mappedBy = "categories")
    open var produits: MutableList<Produit> = mutableListOf()
    ) {

}