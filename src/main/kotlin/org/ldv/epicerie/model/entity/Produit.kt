package org.ldv.epicerie.model.entity

import jakarta.persistence.*

@Entity
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_produit: Long,
    var nom_produit: String,
    var description_produit: String,
    var prix_produit: Double,
) {
}