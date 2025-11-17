package org.ldv.epicerie.model.entity

import java.util.Date

import jakarta.persistence.*

@Entity
class Commentaire(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id_commentaire: Long,
    var texte_commentaire: String,
    val date_commentaire: Date,

    //relation to Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_fkid")
    var utilisateur: Utilisateur? = null,

    //relation to Produit
    @ManyToOne
    @JoinColumn(name = "produit_fkid")
    var produit: Produit? = null,
) {
}