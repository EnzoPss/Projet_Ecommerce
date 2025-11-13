package org.ldv.epicerie.model.entity

import java.util.Date

import jakarta.persistence.*

@Entity
class Commentaire(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_com: Long,
    val idUser: Long,
    val idProduit: Long,
    var texte_com: String,
    val date_com: Date
) {
}