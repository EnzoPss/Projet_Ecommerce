package org.ldv.epicerie.model.entity

import java.util.Date

import jakarta.persistence.*

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_commande: Long,
    val date_commande: Date,
    var status_commande: String,
    var prixTotal_commande: Double
) {
}